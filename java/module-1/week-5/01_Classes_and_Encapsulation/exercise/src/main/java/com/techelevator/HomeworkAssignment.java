package com.techelevator;

public class HomeworkAssignment {
    //Instance variables
    private String letterGrade;
    private String submitterName;
    private int earnedMarks;
    private int possibleMarks;


    public HomeworkAssignment(int possibleMarks, String submitterName) {
        this.possibleMarks = possibleMarks;
        this.submitterName = submitterName;
    }

//    public HomeworkAssignment() {
//
//    }

//Getters and Setters
    public int getEarnedMarks() {
        return earnedMarks;
    }

    public void setEarnedMarks(int earnedMarks) {
        this.earnedMarks = earnedMarks;
    }

    public int getPossibleMarks() {
        return possibleMarks;
    }

    public String getSubmitterName () {
        return submitterName;
    }

    public String getLetterGrade () {
        double convertedPossibleMarks = this.possibleMarks;
        double convertedEarnedMarks = this.earnedMarks;
        double percentage = convertedEarnedMarks / convertedPossibleMarks;
        if (percentage >= .9) {
            return "A";
        } else if (percentage >= .8) {
            return "B";
        } else if (percentage >= .7) {
            return "C";
        } else if (percentage >= .6) {
            return "D";
        } else {
            return "F";
        }
    }


}
