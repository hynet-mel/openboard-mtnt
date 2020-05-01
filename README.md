# OpenBoard + MTNT standard emojis

**Disclaimer: Due to the nature of Mutant Standard font and their placement in the PUA area of Unicode, it's not suggested to use this input in any scenario where screenreaders might be involved. They will be narrated as gibberish and will not be comprehensible for people who rely on such devices. Please use them in a careful and considerate way**

This app is best used asside of the [Mutant Standard magisk module](https://github.com/hynet-mel/mutantstandard_magisk)

![](images/feature.png)

100% FOSS keyboard, based on AOSP.

## What is this fork?

This fork is a fork of [dslul/openboard](https://github.com/dslul/openboard) but with the emoji drawer optimized to display the [Mutant Standard emojis](https://mutant.tech/)

### Permissions
* **Read Contacts**: Used to add your contact list to suggestions. Disabled by default.

# Contribute

### How to create a dictionary
You can use [this tool](https://github.com/remi0s/aosp-dictionary-tools) to create a dictionary. You need a wordlist, as described [here](https://github.com/dslul/openboard/blob/master/dictionaries/sample.combined). The output .dict file must be put in [res/raw](https://github.com/dslul/openboard/tree/master/app/src/main/res/raw).
