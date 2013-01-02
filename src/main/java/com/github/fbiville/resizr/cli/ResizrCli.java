package com.github.fbiville.resizr.cli;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import com.github.fbiville.resizr.core.Resizr;

import java.io.IOException;

@Parameters(separators = "=")
public class ResizrCLI {

    @Parameter(names = {"--picture", "-p"},                         //
                validateValueWith = IsReadablePicture.class,        //
                description = "Path of the picture to resize",      //
                required = true)
    private String picture;

    @Parameter(names = {"--width", "-w"},                           //
                validateValueWith = IsPositiveInteger.class,        //
                description = "Target width (in px)",               //
                required = true)
    private Integer width;

    @Parameter(names = {"--help", "-h"},                            //
                description = "See this help :)",                   //
                help = true)
    private boolean inHelpMode;

    public static void main(String[] args) throws IOException {
        ResizrCLI client = new ResizrCLI();
        JCommander commander = new JCommander(client, args);

        if(client.inHelpMode) {
            commander.setProgramName("resizr");
            commander.usage();
        }
        else {
            new Resizr().resize(client.picture, client.width);
        }
    }

}
