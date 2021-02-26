Architecture: MVVM

Main Tools/Libraries used: RxJava, Dagger, Retrofit, OkHttp, HttpInterceptor

Design and build an Android application that fetches and displays Artist data from the following iTunes url:
https://itunes.apple.com/search?term={any ArtistName}

Functionality:

When the android app is launched, it should display an EditText and button (can be placed anywhere on the screen) named “EnterArtist”.
When an artist name is entered in the field and the button is tapped, a spinner should be shown until the data is downloaded. 
Once the data is available, the spinner should be dismissed, and a scrollable list of the artist’s tracks should be shown. Each item in the list should contain the following data:

artistName

trackName                                                  TrackPrice

releaseDate

primaryGenreName



