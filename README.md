# geocoder-java

This is a fork of the open-source, Apache 2.0-licensed geocoder-java library originally hosted at https://code.google.com/p/geocoder-java/. The primary purpose of this version is to remove the slf4j dependency as it adds over 400 methods, which can be quite a lot when working with Android's dex method limit.