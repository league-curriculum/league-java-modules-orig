package _07_The_Wrong_Way_Cow;
import java.util.HashMap;

public class TheWrongWayCow {
    
    public static int[] findWrongWayCow( final char[][] field ) {
        int[] rowCol = null;
        int northCnt = 0;
        int southCnt = 0;
        int westCnt = 0;
        int eastCnt = 0;
        
        HashMap<String, int[]> hm = new HashMap<String, int[]>(4);
        
        for( int i = 0; i < field.length; i++ ) {
            for( int j = 0; j < field[i].length; j++ ) {
                    
                // Check if the search should continue: 2 directions found and at least 3 cows found
                if( hm.size() > 1 && ( northCnt + southCnt + eastCnt + westCnt ) > 2 ) {
                    // Set i to break out of outer loop
                    i = field.length;
                    break;
                }
                
                // Found a 'c', find the direction of the cow!
                if( field[i][j] == 'c' ) {
                    int numRows = field.length;
                    int numCols = field[i].length;
                    
                    // North
                    if( northCnt < 2 ) {
                        if( i + 2 < numRows && field[i+1][j] == 'o' && field[i+2][j] == 'w' ) {
                            hm.put( "north", new int[] { j, i } );
                            northCnt++;
                            continue;
                        }
                    }
                    
                    // South
                    if( southCnt < 2 ) {
                        if( i - 2 >= 0 && field[i-1][j] == 'o' && field[i-2][j] == 'w' ) {
                            hm.put( "south", new int[] { j, i } );
                            southCnt++;
                            continue;
                        }
                    }
                    
                    // West
                    if( westCnt < 2 ) {
                        if( j + 2 < numCols && field[i][j+1] == 'o' && field[i][j+2] == 'w' ) {
                            hm.put( "west", new int[] { j, i } );
                            westCnt++;
                            continue;
                        }
                    }
                    
                    // East
                    if( eastCnt < 2 ) {
                        if( j - 2 >= 0 && field[i][j-1] == 'o' && field[i][j-2] == 'w' ) {
                            hm.put( "east", new int[] { j, i } );
                            eastCnt++;
                            continue;
                        }
                    }
                }
            }
        }
        
        // Which ever direction has only 1 cow, that's the WWC!
        if( northCnt == 1 ) {
            rowCol = hm.get( "north" );
        } else if( southCnt == 1 ) {
            rowCol = hm.get( "south" );
        } else if( eastCnt == 1 ) {
            rowCol = hm.get( "east" );
        } else if( westCnt == 1 ) {
            rowCol = hm.get( "west" );
        }
        
        return rowCol;
    }
    
/* Solution #2
    public static int[] findWrongWayCow(final char[][] field) {
        int numCows = 0;
        int xCowCoord = -1;
        int yCowCoord = -1;
        final int NORTH = 0;
        final int EAST = 1;
        final int SOUTH = 2;
        final int WEST = 3;
        String strToSearch = "cow";
        String strToSearchRev = "woc";

        for( int direction = NORTH; direction <= WEST; direction++ ) {
            numCows = 0;

            switch( direction ){

            case EAST:
            case WEST:

                // Check if column width is large enough to fit a cow
                // Can use row 0 because field is guaranteed to be rectangular
                if( field[0].length >= strToSearch.length() ) {

                    for( int row = 0; row < field.length; row++ ) {

                        for( int col = 0; col <= field[row].length - strToSearch.length(); col++ ) {
                            String curWord = "";

                            for( int letter = col; letter < col + strToSearch.length(); letter++ ) {
                                curWord += field[row][letter];
                            }

                            if( direction == EAST && curWord.equals( strToSearchRev ) ) {
                                xCowCoord = row;
                                yCowCoord = col + ( strToSearch.length() - 1 );
                                col += strToSearch.length();
                                numCows++;
                            } else if( direction == WEST && curWord.equals( strToSearch ) ) {
                                xCowCoord = row;
                                yCowCoord = col;
                                col += strToSearch.length();
                                numCows++;
                            }
                        }
                    }
                    // Else, there can't be any cows here so leave cow count at 0
                }
                break;

            case NORTH:
            case SOUTH:

                // Check if row height is large enough to fit a cow
                if( field.length >= strToSearch.length() ) {

                    // Can use row 0 because field is guaranteed to be rectangular
                    for( int col = 0; col < field[0].length; col++ ) {

                        for( int row = 0; row <= field.length - strToSearch.length(); row++ ) {
                            String curWord = "";

                            for( int letter = row; letter < row + strToSearch.length(); letter++ ) {
                                curWord += field[letter][col];
                            }

                            if( direction == SOUTH && curWord.equals( strToSearchRev ) ) {
                                xCowCoord = row + ( strToSearch.length() - 1 );
                                yCowCoord = col;
                                row += strToSearch.length();
                                numCows++;
                            } else if( direction == NORTH && curWord.equals( strToSearch ) ) {
                                xCowCoord = row;
                                yCowCoord = col;
                                row += strToSearch.length();
                                numCows++;
                            }
                        }
                    }
                }
                // Else, there can't be any cows here so leave cow count at 0
                break;

            default:
                // Should never get here
                break;
            }

            // Rules say there is exactly 1 WWC
            if( numCows == 1 ) {
                break;
            }
        } // end for directions

        return new int[] { yCowCoord, xCowCoord };
    }
*/
}
