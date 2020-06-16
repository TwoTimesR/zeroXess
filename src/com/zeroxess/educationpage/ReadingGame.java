package com.zeroxess.educationpage;

public class ReadingGame extends Game {
    private String readingText;

    public ReadingGame(String gameTitle) {
        super(gameTitle);
    }

    public String getReadingText() {
        return readingText;
    }

    public void setReadingText(String readingText) {
        this.readingText = readingText;
    }
}
