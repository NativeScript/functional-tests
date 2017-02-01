#!/bin/sh

echo "Default Emulators"
echo no | $ANDROID_HOME/tools/android create avd -n Emulator-Api17-Default -t android-17 --abi default/x86 -c 12M -f
echo no | $ANDROID_HOME/tools/android create avd -n Emulator-Api18-Default -t android-18 --abi default/x86 -c 12M -f
echo no | $ANDROID_HOME/tools/android create avd -n Emulator-Api19-Default -t android-19 --abi default/x86 -c 12M -f
echo no | $ANDROID_HOME/tools/android create avd -n Emulator-Api21-Default -t android-21 --abi default/x86 -c 12M -f
echo no | $ANDROID_HOME/tools/android create avd -n Emulator-Api22-Default -t android-22 --abi default/x86 -c 12M -f
echo no | $ANDROID_HOME/tools/android create avd -n Emulator-Api23-Default -t android-23 --abi default/x86 -c 12M -f
echo no | $ANDROID_HOME/tools/android create avd -n Emulator-Api24-Default -t android-24 --abi default/x86 -c 12M -f

echo "ARM Emulators"
echo no | $ANDROID_HOME/tools/android create avd -n Emulator-Api17-Arm -t android-17 --abi default/armeabi-v7a -c 12M -f
echo no | $ANDROID_HOME/tools/android create avd -n Emulator-Api18-Arm -t android-18 --abi default/armeabi-v7a -c 12M -f
echo no | $ANDROID_HOME/tools/android create avd -n Emulator-Api19-Arm -t android-19 --abi default/armeabi-v7a -c 12M -f
echo no | $ANDROID_HOME/tools/android create avd -n Emulator-Api21-Arm -t android-21 --abi default/armeabi-v7a -c 12M -f
echo no | $ANDROID_HOME/tools/android create avd -n Emulator-Api22-Arm -t android-22 --abi default/armeabi-v7a -c 12M -f
echo no | $ANDROID_HOME/tools/android create avd -n Emulator-Api23-Arm -t android-23 --abi default/armeabi-v7a -c 12M -f
echo no | $ANDROID_HOME/tools/android create avd -n Emulator-Api24-Arm -t android-24 --abi default/armeabi-v7a -c 12M -f

echo "Google APIs x86 Emulators"
echo no | $ANDROID_HOME/tools/android create avd -n Emulator-Api23-Google -t android-23 --abi google_apis/x86 -c 12M -f
echo no | $ANDROID_HOME/tools/android create avd -n Emulator-Api22-Google -t android-22 --abi google_apis/x86 -c 12M -f
echo no | $ANDROID_HOME/tools/android create avd -n Emulator-Api21-Google -t android-21 --abi google_apis/x86 -c 12M -f
echo no | $ANDROID_HOME/tools/android create avd -n Emulator-Api19-Google -t android-19 --abi google_apis/x86 -c 12M -f

echo "Nexus 5 Emulators"
echo no | $ANDROID_HOME/tools/android create avd -n Emulator-Api19-Nexus5 -t android-19 --abi default/x86 --skin "Nexus 5" -c 12M -f
echo no | $ANDROID_HOME/tools/android create avd -n Emulator-Api21-Nexus5 -t android-21 --abi default/x86 --skin "Nexus 5" -c 12M -f
echo no | $ANDROID_HOME/tools/android create avd -n Emulator-Api22-Nexus5 -t android-22 --abi default/x86 --skin "Nexus 5" -c 12M -f
echo no | $ANDROID_HOME/tools/android create avd -n Emulator-Api23-Nexus5 -t android-23 --abi default/x86 --skin "Nexus 5" -c 12M -f

echo "Nexus 6 Emulators"
echo no | $ANDROID_HOME/tools/android create avd -n Emulator-Api21-Nexus6 -t android-21 --abi default/x86 --skin "Nexus 6" -c 12M -f
echo no | $ANDROID_HOME/tools/android create avd -n Emulator-Api22-Nexus6 -t android-22 --abi default/x86 --skin "Nexus 6" -c 12M -f
echo no | $ANDROID_HOME/tools/android create avd -n Emulator-Api23-Nexus6 -t android-23 --abi default/x86 --skin "Nexus 6" -c 12M -f

echo "Nexus 7 Emulators (Asus Tablets)"
echo no | $ANDROID_HOME/tools/android create avd -n Emulator-Api21-Nexus7 -t android-21 --abi default/x86 --skin "Nexus 7" -c 12M -f
echo no | $ANDROID_HOME/tools/android create avd -n Emulator-Api22-Nexus7 -t android-22 --abi default/x86 --skin "Nexus 7" -c 12M -f
echo no | $ANDROID_HOME/tools/android create avd -n Emulator-Api23-Nexus7 -t android-23 --abi default/x86 --skin "Nexus 7" -c 12M -f

echo "Nexus 10 Emulators (Samsung Tablets)"
echo no | $ANDROID_HOME/tools/android create avd -n Emulator-Api21-Nexus10 -t android-21 --abi default/x86 --skin "Nexus 10" -c 12M -f
echo no | $ANDROID_HOME/tools/android create avd -n Emulator-Api22-Nexus10 -t android-22 --abi default/x86 --skin "Nexus 10" -c 12M -f
echo no | $ANDROID_HOME/tools/android create avd -n Emulator-Api23-Nexus10 -t android-23 --abi default/x86 --skin "Nexus 10" -c 12M -f
