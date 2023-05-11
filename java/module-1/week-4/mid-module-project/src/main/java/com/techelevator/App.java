package com.techelevator;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

public class App {

    // The regex string to split the Strings in the dataset.
    private static final String FIELD_DELIMITER = "\\|";

    private static final int TITLE_FIELD = 0;
    private static final int AUTHOR_FIELD = 1;
    private static final int PUBLISHED_YEAR_FIELD = 2;
    private static final int PRICE_FIELD = 3;

    private final Scanner keyboard = new Scanner(System.in);

    private List<String> titles = new ArrayList<>();
    private List<String> authors = new ArrayList<>();
    private List<Integer> publishedYears = new ArrayList<>();
    private List<BigDecimal> prices = new ArrayList<>();

    public static void main(String[] args) {

        App app = new App();
        app.loadData();
        app.run();

    }

    private void loadData() {

        String[] dataset = Dataset.load();

        /*
         Requirement: 1
         Populate the instance variables `titles`, `authors`, `publishedYears`,
         and `prices` by splitting each string in the `dataset` array and adding
         the individual fields to the appropriate list.
         See README for additional details.
         */


        //split the data set by delimiter
        for (String i : dataset) {
            String[] subStringData = i.split(FIELD_DELIMITER);

            // add each field to appropriate list
            for (int x = 0; x <= 0; x += 4) {
                titles.add(subStringData[x]);
                authors.add(subStringData[x + 1]);
                int subStringDataToInt = Integer.parseInt(subStringData[x + 2]);
                publishedYears.add(subStringDataToInt);
                BigDecimal subStringDataToBigDecimal = new BigDecimal(subStringData[x + 3]);
                prices.add(subStringDataToBigDecimal);
            }
        }
    }


    private void run() {

        while (true) {
            // Main menu loop
            printMainMenu();
            int mainMenuSelection = promptForMenuSelection("Please choose an option: ");
            if (mainMenuSelection == 1) {
                // Display data and subsets loop
                while (true) {
                    printDataAndSubsetsMenu();
                    int dataAndSubsetsMenuSelection = promptForMenuSelection("Please choose an option: ");
                    if (dataAndSubsetsMenuSelection == 1) {
                        displayDataset(Dataset.load());
                    } else if (dataAndSubsetsMenuSelection == 2) {
                        displayTitlesList(titles);
                    } else if (dataAndSubsetsMenuSelection == 3) {
                        displayAuthorsList(authors);
                    } else if (dataAndSubsetsMenuSelection == 4) {
                        displayPublishedYearsList(publishedYears);
                    } else if (dataAndSubsetsMenuSelection == 5) {
                        displayPricesList(prices);
                    } else if (dataAndSubsetsMenuSelection == 0) {
                        break;
                    }
                }
            } else if (mainMenuSelection == 2) {
                while (true) {
                    printSearchBooksMenu();
                    int searchBooksMenuSelection = promptForMenuSelection("Please choose an option: ");
                    if (searchBooksMenuSelection == 1) {
                        // Search by title
                        String filterTitle = promptForString("Enter title: ");
                        /*
                         Requirement: 3b
                         Replace `displayTitlesList(titles)` with calls to the
                         `filterByTitle()` and `displaySearchResults()` methods.
                         */

                        //Remove displayTitlesList(titles)'
                        //displayTitlesList(titles);

                        //Replace with calls to filterByTitle and displaySearchResults() methods
                        displaySearchResults(filterByTitle(filterTitle));


                    } else if (searchBooksMenuSelection == 2) {
                        // Search by author
                        String filterAuthor = promptForString("Enter author: ");
                        /*
                         Requirement: 4b
                         Replace `displayAuthorsList(authors)` with calls to the
                         `filterByAuthor()` and `displaySearchResults()` methods.
                         */

                        //Remove displayAuthorsList(authors);
                        //displayAuthorsList(authors);

                        //Replace with calls to filterByAuthor and displaySearchResults() methods
                        displaySearchResults(filterByAuthor(filterAuthor));


                    } else if (searchBooksMenuSelection == 3) {
                        // Search by published year
                        int filterYear = promptForPublishedYear("Enter date (YYYY): ");
                        /*
                         Requirement: 5b
                         Replace `displayPublishedYearsList(publishedYears)` with calls
                         to the `filterByPublishedYear()` and `displaySearchResults()` methods.
                         */

                        //Remove displayPublishedYearsList(publishedYears);
                        //displayPublishedYearsList(publishedYears);

                        //Replace with calls to filterByPublishedYear() and displaySearchResults() methods
                        displaySearchResults(filterByPublishedYear(filterYear));

                    } else if (searchBooksMenuSelection == 4) {
                        // Search by published year range
                        int filterFromYear = promptForPublishedYear("Enter \"from\" date (YYYY): ");
                        int filterToYear = promptForPublishedYear("Enter \"to\" date (YYYY): ");
                        /*
                         Requirement: 6b
                         Replace `displayPublishedYearsList(publishedYears)` with calls
                         to the `filterByPublishedYearRange()` and `displaySearchResults()` methods.
                         */

                        //Remove displayPublishedYearsList(publishedYears);
                        //displayPublishedYearsList(publishedYears);

                        ////Replace with calls to filterByPublishedYearRange() and displaySearchResults() methods
                        displaySearchResults(filterByPublishedYearRange(filterFromYear, filterToYear));

                    } else if (searchBooksMenuSelection == 5) {
                        // Find the most recent books
                        /*
                         Requirement: 7b
                         Replace `displayPublishedYearsList(publishedYears)` with calls
                         to the `findMostRecentBooks()` and `displaySearchResults()` methods.
                         */
                        displayPublishedYearsList(publishedYears);
                    } else if (searchBooksMenuSelection == 6) {
                        // Search by price
                        double filterPrice = promptForPrice("Enter price: ");
                        /*
                         Requirement: 8b
                         Replace `displayPricesList(prices)` with calls to the
                         `filterByPrice()` and `displaySearchResults()` methods.
                         */
                        displayPricesList(prices);
                    } else if (searchBooksMenuSelection == 7) {
                        // Search by price range
                        double filterFromPrice = promptForPrice("Enter \"from\" price: ");
                        double filterToPrice = promptForPrice("Enter \"to\" price: ");
                        /*
                         Requirement: 9b
                         Replace `displayPricesList(prices)` with calls to the
                         `filterByPriceRange()` and `displaySearchResults()` methods.
                         */
                        displayPricesList(prices);
                    } else if (searchBooksMenuSelection == 8) {
                        // Find the least expensive books
                        /*
                         Requirement: 10b
                         Replace `displayPricesList(prices)` with calls to the
                         `findLeastExpensiveBooks()` and `displaySearchResults()` methods.
                         */
                        displayPricesList(prices);
                    } else if (searchBooksMenuSelection == 0) {
                        break;
                    }
                }
            } else if (mainMenuSelection == 0) {
                break;
            }
        }

    }

    /*
     Requirement: 2
     Write the displaySearchResults(List<Integer> indexes) method.
     See README for additional details.
     */
    private void displaySearchResults(List<Integer> indexes) {

        //Loop through indexes
        for (Integer i : indexes) {
            //Print out SearchResults
            System.out.println(titles.get(i) + " " + authors.get(i) + " " + publishedYears.get(i) + " "
                    + prices.get(i));

        }
    }


    /*
     Requirement: 3a
     Complete the `filterByTitle()` method.
     See README for additional details.
     */
    private List<Integer> filterByTitle(String filterTitle) {
        //declare List of found matches for Titles
        List<Integer> foundTitles = new ArrayList<>();

        //Find matching Titles by loop
        for (String i : titles) {
            String a = i.toUpperCase();
            String b = filterTitle.toUpperCase();
            if (a.contains(b)) {
                foundTitles.add(titles.indexOf(i));
            }
        }
        return foundTitles;
    }

    /*
     Requirement: 4a
     Complete the `filterByAuthor()` method.
     See README for additional details.
     */
    private List<Integer> filterByAuthor(String filterAuthor) {
        //Declare list of found matches for authors
        List<Integer> foundAuthors = new ArrayList<>();

        //Find matching Authors by loop
        for (String i : authors) {
            String a = i.toUpperCase();
            String b = filterAuthor.toUpperCase();
            if (a.equalsIgnoreCase(b)) {
                foundAuthors.add(authors.indexOf(i));
            }
        }
        return foundAuthors;
    }

    /*
     Requirement: 5a
     Complete the `filterByPublishedYear()` method.
     See README for additional details.
     */
    private List<Integer> filterByPublishedYear(int filterYear) {
        //Declare list of found matches for published year
        List<Integer> foundPublishedYear = new ArrayList<>();

        //Find matching published year by loop
        for (Integer i : publishedYears) {
            LocalDate date = LocalDate.of(i, 1, 1);
            int year = date.getYear();
            if (year == filterYear) {
                foundPublishedYear.add(publishedYears.indexOf(i));
            }
        }
        return foundPublishedYear;
    }

    // Currently not working, maybe need to convert to local date or create two list>find matches> return non matches.
// or can remove matches prior to from date and remove matches post to date.
    /*
     Requirement: 6a
     Complete the `filterByPublishedYearRange()` method.
     See README for additional details.
     */
    private List<Integer> filterByPublishedYearRange(int filterFromYear, int filterToYear) {
        //Declare list of found matches for Published Years by Range
        List<Integer> foundPublishedYearByRange = new ArrayList<>();


        //Find matching published years by from year via loop
        for (Integer i : publishedYears) {
            if (i >= filterFromYear) {
                foundPublishedYearByRange.add(publishedYears.indexOf(i));
            }
        }
        //Remove matching published years by To Year via loop
        for (Integer i : foundPublishedYearByRange) {
            if (i >= filterToYear) {
                foundPublishedYearByRange.remove(foundPublishedYearByRange.indexOf(i));
            }
        }
        return foundPublishedYearByRange;
    }

    /*
     Requirement: 7a
     Add the `private List<Integer> findMostRecentBooks()` method.
     See README for additional details.
     */

    //Add the method
    private List<Integer> findMostRecentBooks(int filterRecentYear) {

        //Declare a list for latest publications
        List<Integer> latestPublications = new ArrayList<>();

        //Determine the latest year of publication years withing published years
        for (int i = 0; i <=0; i++) {
            int mostRecentPublication = 0;
            if (publishedYears.indexOf(i) >= mostRecentPublication) {
                mostRecentPublication = publishedYears.indexOf(i);
            }
            for (Integer x : publishedYears) {
                if (x == mostRecentPublication) {
                    latestPublications.add(x);
                }
            }
        }

        return latestPublications;
    }


    /*
     Requirement: 8a
     Complete the `filterByPrice()` method.
     See README for additional details.
     */
            private List<Integer> filterByPrice(double filterPrice) {
                return null;
            }

    /*
     Requirement: 9a
     Complete the `filterByPriceRange()` method.
     See README for additional details.
     */
            private List<Integer> filterByPriceRange(double filterFromPrice, double filterToPrice) {
                return null;
            }

    /*
     Requirement: 10a
     Add the `private List<Integer> findLeastExpensiveBooks()` method.
     See README for additional details.
     */


            // UI methods

            private void printMainMenu() {
                System.out.println("1: Display data and subsets");
                System.out.println("2: Search books");
                System.out.println("0: Exit");
                System.out.println();
            }

            private void printDataAndSubsetsMenu() {
                System.out.println("1: Display dataset");
                System.out.println("2: Display titles");
                System.out.println("3: Display authors");
                System.out.println("4: Display published years");
                System.out.println("5: Display prices");
                System.out.println("0: Return to main menu");
                System.out.println();
            }

            private void printSearchBooksMenu() {
                System.out.println("1: Search by title");
                System.out.println("2: Search by author");
                System.out.println("3: Search by published year");
                System.out.println("4: Search by published year range");
                System.out.println("5: Find most recent books");
                System.out.println("6: Search by price");
                System.out.println("7: Search by price range");
                System.out.println("8: Find least expensive books");
                System.out.println("0: Return to main menu");
                System.out.println();
            }

            private void displayDataset(String[] dataset) {
                System.out.println("Dataset");
                System.out.println("-------");
                for (String data : dataset) {
                    System.out.println(data);
                }
                System.out.println();
                promptForReturn();
            }

            private void displayTitlesList(List<String> titles) {
                System.out.println("Titles");
                System.out.println("-------");
                for (int i = 0; i < titles.size(); i++) {
                    System.out.println(i + ": " + titles.get(i));
                }
                System.out.println();
                promptForReturn();
            }

            private void displayAuthorsList(List<String> authors) {
                System.out.println("Authors");
                System.out.println("-------");
                for (int i = 0; i < authors.size(); i++) {
                    System.out.println(i + ": " + authors.get(i));
                }
                System.out.println();
                promptForReturn();
            }

            private void displayPublishedYearsList(List<Integer> publishedYears) {
                System.out.println("Published Years");
                System.out.println("---------------");
                for (int i = 0; i < publishedYears.size(); i++) {
                    System.out.println(i + ": " + publishedYears.get(i));
                }
                System.out.println();
                promptForReturn();
            }

            private void displayPricesList(List<BigDecimal> prices) {
                System.out.println("Prices");
                System.out.println("------");
                for (int i = 0; i < prices.size(); i++) {
                    System.out.println(i + ": " + prices.get(i));
                }
                System.out.println();
                promptForReturn();
            }

            private int promptForMenuSelection(String prompt) {
                System.out.print(prompt);
                int menuSelection;
                try {
                    menuSelection = Integer.parseInt(keyboard.nextLine());
                } catch (NumberFormatException e) {
                    menuSelection = -1;
                }
                return menuSelection;
            }

            private String promptForString(String prompt) {
                System.out.print(prompt);
                return keyboard.nextLine();
            }

            private int promptForPublishedYear(String prompt) {
                int year;
                while (true) {
                    System.out.println(prompt);
                    try {
                        year = Integer.parseInt(keyboard.nextLine());
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("The year provided is not well-formed. It must be YYYY.");
                    }
                }
                return year;
            }

            private double promptForPrice(String prompt) {
                double price;
                while (true) {
                    System.out.println(prompt);
                    try {
                        price = Double.parseDouble(keyboard.nextLine());
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("The price provided is not a valid monetary value.");
                    }
                }
                return price;
            }

            private void promptForReturn() {
                System.out.println("Press RETURN to continue.");
                keyboard.nextLine();
            }
        }

