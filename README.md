# Mobile-App-Development-Test
## This is for test part 1 of signing in suitmedia

### FirstScreen
1. It has two inputTexts and two buttons. 
2. One inputText for name input and the other for input sentence text, to check whether the sentence is palindrome or not.
    - Example :
        - e.g isPalindrome(“kasur rusak”) -> true
        - e.g isPalindrome(“step on no pets”) -> true
        - e.g isPalindrome(“put it up”) -> true
        - e.g isPalindrome(“suitmedia”) -> false
3. A button with a “Check” title below the inputTexts
4. Show as dialog with message “isPalindrome” if it’s palindrome and message “not   palindrome” if it’s not palindrome when clicking the button check.
5. And a button with a “Next” title below the Check Button.
6. Go to the Second Screen when clicking the Next button

### SecondScreen
1. It has a static “Welcome” text label/textview
2. And it has two dynamic labels / textviews for the show name from the first screen and the other one is the Selected User Name label.
3. It has a button “Choose a User”.
4. Action click button “Choose a User” for goto third screen.

### ThirdScreen
1. It has a List / Table view of Users
2. Collect data from api from regres.in with email, first_name, last_name & avatar
3. Add a pull to refresh and load the next page when scrolling to the bottom of the list, and prepare an empty state if data is empty. You can use the API with adding parameter page & per_page to get next page data.
4. When a User on an item list is clicked, the Selected User Name label in “Second Screen” will be replaced by the selected User’s name (don’t create a new screen, just continue the current screen).

![](ss/1.png)
![](ss/2.png)
![](ss/3.png)
