//LECTURE DEMO
/*
// Add listener to document (DOM) so my DOM manipulation occurrs
// after the DOMContentLoaded event
document.addEventListener('DOMContentLoaded', onDomLoad);

// Code to execute when the DOM is ready
function onDomLoad(){

// 1. Get element to listen for events
const buttonEl = document.getElementById('my-button');
const buttonEl2 = document.getElementById('my-button2');

// 2. Add the listener and the event to listen for
buttonEl.addEventListener('click', onButtonClick);
buttonEl2.addEventListener('click', onButtonClick);
buttonEl2.addEventListener('keyup', (event) => {
  console.log(`The key that was pressed/released was: ${event.key}`);

});
}
// 3. Define the callback to run when the event occurs
function onButtonClick(event){
  const elementThatWasClicked = event.target;

  elementThatWasClicked.innerText = 'OUCH!';

  console.log(elementThatWasClicked.innerText);
  //alert(elementThatWasClicked.innerText);
}
*/