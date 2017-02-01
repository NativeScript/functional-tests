#!/bin/sh

echo "iOS Simulators"
xcrun simctl create "iPhone 5 81" "iPhone 5" "8.1"
xcrun simctl create "iPhone 5s 84" "iPhone 5" "8.4"

xcrun simctl create "iPhone 6 81" "iPhone 6" "8.1"
xcrun simctl create "iPhone 6 91" "iPhone 6" "9.1"
xcrun simctl create "iPhone 6 93" "iPhone 6" "9.3"
xcrun simctl create "iPhone 6 Plus 90" "iPhone 6 Plus" "9.0"

xcrun simctl create "iPhone 6s 91" "iPhone 6s" "9.1"
xcrun simctl create "iPhone 6s 92" "iPhone 6s" "9.2"
xcrun simctl create "iPhone 6s Plus 91" "iPhone 6s Plus" "9.1"