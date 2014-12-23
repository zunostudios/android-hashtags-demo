package com.zuno.linkdemo;

//   Lorem ipsum generator
//   http://loremipsum.sourceforge.net/
//   Modified by David Nuon - added cupcake ipsum, bacon ipsum hashtags and callouts.

/* Copyright (c) 2008 Sven Jacobs

   Permission is hereby granted, free of charge, to any person obtaining a copy
   of this software and associated documentation files (the "Software"), to deal
   in the Software without restriction, including without limitation the rights
   to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
   copies of the Software, and to permit persons to whom the Software is
   furnished to do so, subject to the following conditions:

   The above copyright notice and this permission notice shall be included in
   all copies or substantial portions of the Software.

   THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
   IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
   FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
   AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
   LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
   OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
   THE SOFTWARE. 
*/

/**
 * Simple lorem ipsum text generator.
 * 
 * <p>
 *   Suitable for creating sample data for test cases and performance tests.
 * </p>
 *
 * @author Sven Jacobs
 * @version 1.0
 */
public class LoremIpsum {
  public static final String LOREM_IPSUM = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.";
    public static final String[] CORPUS =  {
            "Bacon ipsum dolor sit amet jerky andouille beef ribs sausage pastrami shoulder landjaeger ball tip pork loin ground round leberkas tail porchetta swine rump drumstick chop turkey pig brisket kielbasa shank kevin turducken rump short boudin prosciutto bacon hamburger chuck meatloaf tenderloin flank sirloin pork venison ribeye tongue shankle bresaola belly salami filet mignon tri-tip pastrami jowl shoulder meatball doner frankfurter t-bone chicken biltong brisket tenderloin ham hock pancetta strip steak flank porchetta prosciutto beef fatback hamburger corned meatball corned chuck ground capicola kevin frankfurter spare pancetta meatloaf cow strip sausage ham leberkas spare tail filet fatback sirloin kielbasa cow salami ball.",
            "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.",
            "Soufflé marshmallow bear claw fruitcake jelly-o. Muffin brownie wafer pie sugar plum oat cake caramels sesame snaps pastry. Danish icing gummies fruitcake marshmallow cheesecake soufflé. Donut lollipop ice cream carrot cake biscuit. Sweet roll chocolate bar powder jelly bonbon. Jelly-o danish jujubes muffin marzipan unerdwear.com dragée jujubes cotton candy. Pastry sweet roll lollipop unerdwear.com jelly-o. Gummies chocolate fruitcake lollipop brownie. Lollipop chocolate cake powder toffee."
    };
  private String[] loremIpsumWords;
 
  public LoremIpsum() {
    this.loremIpsumWords = CORPUS[(int) (Math.random() * CORPUS.length)].split("\\s");
  }
  
  /**
   * Returns one sentence (50 words) of the lorem ipsum text.
   *
   * @return 50 words of lorem ipsum text
   */
  public String getWords() {
    return getWords( 50 );
  }
  
  /**
   * Returns words from the lorem ipsum text.
   *
   * @param amount Amount of words
   * @return Lorem ipsum text
   */
  public String getWords( int amount ) {
    return getWords( amount, 0 );
  }
  
  /**
   * Returns words from the lorem ipsum text.
   *
   * @param amount Amount of words
   * @param startIndex Start index of word to begin with (must be >= 0 and < 50)
   * @return Lorem ipsum text
   * @throws IndexOutOfBoundsException If startIndex is < 0 or > 49
   */
  public String getWords( int amount, int startIndex ) {
   this.loremIpsumWords = CORPUS[(int) (Math.random() * CORPUS.length)].split("\\s");
    if ( startIndex < 0 || startIndex > 49 ) {
      throw new IndexOutOfBoundsException( "startIndex must be >= 0 and < 50" );
    }
  
    int word = startIndex;
    StringBuilder lorem = new StringBuilder();
  
    for( int i = 0; i < amount; i++ ) {
      if ( word == 50 ) {
        word = 0;
      }

      // Random links
      int dice = (int)(Math.random() * 6);
      if( dice == 0 ) {
          lorem.append( '#' );
      }

        if( dice == 3 ) {
            lorem.append( '@' );
        }
      lorem.append( loremIpsumWords[ word ] );

      if ( i < amount - 1 ) {
        lorem.append( ' ' );
      }



      word++;
    }
    
    return lorem.toString();  
  }
  
  /**
   * Returns two paragraphs of lorem ipsum.
   *
   * @return Lorem ipsum paragraphs
   */
  public String getParagraphs() {
    return getParagraphs( 2 );
  }
  
  /**
   * Returns paragraphs of lorem ipsum.
   *
   * @param amount Amount of paragraphs
   * @return Lorem ipsum paragraphs
   */
  public String getParagraphs( int amount ) {
    StringBuilder lorem = new StringBuilder();
  
    for( int i = 0; i < amount; i++ ) {
      lorem.append(  CORPUS[(int) (Math.random() * CORPUS.length)] );
      
      if ( i < amount - 1 ) {
        lorem.append( "\n\n" );
      }
    }
    
    return lorem.toString();
  }
}
