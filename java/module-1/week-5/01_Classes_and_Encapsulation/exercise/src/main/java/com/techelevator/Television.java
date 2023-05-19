package com.techelevator;

import java.math.BigDecimal;

public class Television {
    //Instance Variables
    private boolean isOn = false;
    private int currentChannel = 3;
    private int currentVolume = 2;

    //Constructors
    //n/a

    //Getter


    public Boolean getIsOn() {
        return this.isOn;
    }

    public int getCurrentChannel() {
        return this.currentChannel;
    }

    public int getCurrentVolume() {
        return this.currentVolume;
    }

    //methods
    public void turnOff() {
        isOn = false;
    }

    public void turnOn() {
        isOn = true;
    }

    public void changeChannel(int newChannel) {
        if(isOn && newChannel >= 3 && newChannel <= 18) {
            currentChannel = newChannel;
        }
    }

    public void channelUp() {
        if(isOn) {
            currentChannel += 1;
        }
        if(currentChannel > 18) {
            currentChannel = 3;
        }
    }

    public void channelDown() {
        if(isOn == true) {
            currentChannel -= 1;
        }
        if(currentChannel < 3) {
            currentChannel = 18;
        }
    }

    public void raiseVolume() {
        if(isOn == true && currentVolume < 10) {
            currentVolume += 1;
        }
    }

    public void lowerVolume() {
        if(isOn == true && currentVolume > 0) {
            currentVolume -= 1;
        }
    }

    public boolean isOn() {
        return this.isOn;
    }

}
