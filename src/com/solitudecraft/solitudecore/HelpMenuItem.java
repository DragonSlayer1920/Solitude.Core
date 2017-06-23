package com.solitudecraft.solitudecore;

/**
 * Created by nolan on 6/17/2017.
 */
public class HelpMenuItem {
    public String command;
    public String subCommand;
    public String explanation;

    public HelpMenuItem(String cmd, String subCmd, String exp) {
        command = cmd;
        subCommand = subCmd;
        explanation = exp;
    }
}
