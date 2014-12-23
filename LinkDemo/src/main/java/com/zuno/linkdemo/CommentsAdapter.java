package com.zuno.linkdemo;
import android.app.Activity;
import android.content.Context;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommentsAdapter extends BaseAdapter {
    private ArrayList<Comment> comments = new ArrayList<Comment>();
    private Context context;
    private Holder holder;

    static class Holder {
        TextView username;
        TextView comments;
    };

    public CommentsAdapter(ArrayList<Comment> comments, Context context) {
        this.comments = comments;
        this.context = context;
    }

    @Override
    public int getCount() {
        return comments.size();
    }

    @Override
    public Object getItem(int position) {
        return comments.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public ArrayList<int[]> getSpans(String body, char prefix) {
        ArrayList<int[]> spans = new ArrayList<int[]>();

        Pattern pattern = Pattern.compile(prefix + "\\w+");
        Matcher matcher = pattern.matcher(body);

        // Check all occurrences
        while (matcher.find()) {
            int[] currentSpan = new int[2];
            currentSpan[0] = matcher.start();
            currentSpan[1] = matcher.end();
            spans.add(currentSpan);
        }

        return  spans;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater mInflater =  (LayoutInflater) context
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.listitem_comment, null);

            this.holder = new Holder();
            this.holder.comments = (TextView) convertView.findViewById(R.id.comment_text);
            this.holder.username = (TextView) convertView.findViewById(R.id.username);

            convertView.setTag(this.holder);
        } else {
            this.holder = (Holder) convertView.getTag();
        }

        this.holder.username.setText(this.comments.get(position).getUserName().toUpperCase());
        String commentsText = this.comments.get(position).getComment();

        ArrayList<int[]> hashtagSpans = getSpans(commentsText, '#');
        ArrayList<int[]> calloutSpans = getSpans(commentsText, '@');

        SpannableString commentsContent =
                new SpannableString(this.comments.get(position).getComment());

        for(int i = 0; i < hashtagSpans.size(); i++) {
            int[] span = hashtagSpans.get(i);
            int hashTagStart = span[0];
            int hashTagEnd = span[1];

            commentsContent.setSpan(new Hashtag(context),
                    hashTagStart,
                    hashTagEnd, 0);

        }

        for(int i = 0; i < calloutSpans.size(); i++) {
            int[] span = calloutSpans.get(i);
            int calloutStart = span[0];
            int calloutEnd = span[1];

            commentsContent.setSpan(new CalloutLink(context),
                    calloutStart,
                    calloutEnd, 0);

        }

        this.holder.comments.setMovementMethod(LinkMovementMethod.getInstance());
        this.holder.comments.setText(commentsContent);
        return convertView;
    }
}
