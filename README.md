# SneakerDroid
An android app to register a participant into the system and collect phone data from events derived from user actions.

## Tasks include:
1. User registration
* Allow user to register by providing below details. The endpoint should return an
access token which should be used for all successive API calls.

2. Collect data on Software Information
* Software Information refers to the apps installed on the phone. Data collection
assumes event-based actions and should record data on which app was installed,
uninstalled or updated. On every event, the name of the app and status should be collected.

3. Data uploads
* The data collected should be uploaded to a cloud service provided every 30 minutes, if
the user is on the internet.
* Besides data collected at stage #2, data uploads require appending other metadata
see upload API for more details.
