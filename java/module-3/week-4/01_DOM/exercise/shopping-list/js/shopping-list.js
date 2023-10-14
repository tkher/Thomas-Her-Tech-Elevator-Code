// add pageTitle
const title = document.getElementById('title');
const groceriesId = document.getElementById('groceries');

let pageTitle = "My Shopping List";
let groceries = [];


// add groceries
function myGroceries() {
  groceries = [
    {id: 1, item: 'Eggs'},
    {id: 2, item: 'Milk'},
    {id: 3, item: 'Juice'},
    {id: 4, item: 'Bread'},
    {id: 5, item: 'Apples'},
    {id: 6, item: 'Steak'},
    {id: 7, item: 'Chicken'},
    {id: 8, item: 'Grey-poupond'},
    {id: 9, item: 'Butterfingers'},
    {id: 10, item: 'A feather from a one-eyed crow'}
  ]
}

/**
 * This function will get a reference to the title and set its text to the value
 * of the pageTitle variable that was set above.
 */
function setPageTitle() {
  const heading = document.createElement('h1');
  heading.innerText = pageTitle;
  title.appendChild(heading);
}

/**
 * This function will loop over the array of groceries that was set above and add them to the DOM.
 */

function displayGroceries() {
  //const ul = document.createElement('ul');
  //groceries.appendChild(ul); // might not need
  
  groceries.forEach(grocery => {
    const newList = document.createElement('li');
    newList.innerText = grocery.item;
    groceriesId.appendChild(newList);
  })

}

/**
 * This function will be called when the button is clicked. You will need to get a reference
 * to every list item and add the class completed to each one
 */
function markCompleted() {
  const allItems = document.querySelectorAll('li');
  allItems.forEach((item)=> {
    if(!item.classList.contains('completed')) {
      item.classList.add('completed');
    }
  })
}

myGroceries();

setPageTitle();

displayGroceries();

// Don't worry too much about what is going on here, we will cover this when we discuss events.
document.addEventListener('DOMContentLoaded', () => {
  // When the DOM Content has loaded attach a click listener to the button
  const button = document.querySelector('.btn');
  button.addEventListener('click', markCompleted);
});
