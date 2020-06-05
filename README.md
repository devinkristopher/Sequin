# Sequin

Sequin is a platform for Java Musical Instrument Digital Interface (MIDI) Development (okay, not yet- but it will be expanded upon!).  I developed this in Fall '19 for the CREATE Symposium at Georgia Gwinnett College.  The topic at hand was JavaFX game development.  I justified the classification by categorizing it akin to Guitar Hero, Synthesia, Rock Band, or the plethora of piano apps that are available for mobile devices.  Most of them, if not all, use MIDI in some fashion.  It is the standard for integrating musical events with computers.

I believe the initial upload to be the exact code I ran at the event.  Excuse the bad coding practices, I made the entire program in about 6 hours or so as the event fell on an exceptionally busy week of mine.  It is very conglomerated code with basic functionality, but I wanted to document the software every step along the way.  Aside from some CSS styling, the initial version shows the bare minimum code it takes to make a computer keyboard act as a (non velocity-sensitive) musical keyboard.

It took me a while to figure out the EventListener configuration, so I figured I would make it open-source for the world to use as a reference.  Feel free to use it for informational purposes, personal use, or any other use you may find.  I just ask that you let me know what it is up to around the world so I can get a sense of pride from it!

If you're wondering, the Javatron name is inspired by the Mellotron synthesizer brand.  Sequin is derived from the MIDI term sequencer.

# Short Instructions

Run the Javatron.java file!

# Long Instructions (Eclipse Build Path)

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

# Credits

I would like to thank Dr. Wei Jin at GGC for convincing me to make a submission to the CREATE Symposium.  Had she not pushed me out of my comfort zone, this project would have never came to be.  Thanks Dr. Jin!
