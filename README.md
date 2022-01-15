# Mobile-App-Development-Test
This is for test part 1 of signing in suitmedia

PART 1
This application has 3 screens.
First Screen
It has two inputTexts and two buttons. 
One inputText for name input and the other for input sentence text, to check whether the sentence is palindrome or not.
Example :
e.g isPalindrome(“kasur rusak”) -> true
e.g isPalindrome(“step on no pets”) -> true
e.g isPalindrome(“put it up”) -> true
e.g isPalindrome(“suitmedia”) -> false
A button with a “Check” title below the inputTexts
Show as dialog with message “isPalindrome” if it’s palindrome and message “not   palindrome” if it’s not palindrome when clicking the button check.
And a button with a “Next” title below the Check Button.
Go to the Second Screen when clicking the Next button
Second Screen
It has a static “Welcome” text label/textview
And it has two dynamic labels / textviews for the show name from the first screen and the other one is the Selected User Name label.
It has a button “Choose a User”.
Action click button “Choose a User” for goto third screen.
Third Screen
It has a List / Table view of Users
Collect data from api from regres.in with email, first_name, last_name & avatar
Add a pull to refresh and load the next page when scrolling to the bottom of the list, and prepare an empty state if data is empty. You can use the API with adding parameter page & per_page to get next page data.
When a User on an item list is clicked, the Selected User Name label in “Second Screen” will be replaced by the selected User’s name (don’t create a new screen, just continue the current screen).

For illustration wireframe design you can see it on the next page.
Send your repository link, screenshot and apk (android).

You can login using figma to look the prototype and have the assets
https://www.figma.com/file/0QV3L03QMWI3p6g2DE97x9/KM-Test?node-id=0%3A1
