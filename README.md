# Sequin

Sequin is a platform for MIDI Java Development that I plan on expanding upon.  Currently, the software design is likely a conglomeration-style which is not optimal.  I developed this program 6 months ago or so for a CREATE Symposium for GGC about Java game development (categorizing it akin to Guitar Hero, Synthesia, or Rock Band).  Currently, it is in a very minimal state.  It took me a while to figure out the EventListener configuration, so I figured I would make it open-source for the world to use as a reference.  Feel free to use it for informational purposes, personal use, or any other use you may find.  I just ask that you let me know what it is up to so around the world that I may have a sense of pride from it!

# Short Instructions

Run the Javatron.java file!

# Long Instructions

This program has been tested and ran on macOS Catalina 10.15.3 (MacBook Pro 2019 w/ TouchBar) using Eclipse IDE 2019-06 (4.12.0).

If you have issues, please make sure that you are using a version of Java that supports JavaFX.  If you are on a recent version, you may need OpenJFX by Gluon.  Once you have JavaFX configured and Sequin set up as a project, proceed to the following steps:

- Right Click Project > Build Path > Configure Build Path
- Click on the Libraries tab
- Expand the JRE System Library (mine is: [JavaSE-1.8]) by clicking the dropdown button
  - It may say: Access rules: No rules defined
- Click on Access Rules
- Click Edit on the right BorderPane region
- Click Add in the new window that pops up
- For Resolution, set it to accessible
- For the rule pattern, type javafx/**
- Click OK on the two windows that popped up, and then Apply and Close

Run Javatron.java

If you have any questions, please message me.  I will respond usually within the same day.  Have fun!
