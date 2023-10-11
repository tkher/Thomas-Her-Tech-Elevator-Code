//LECTURE DEMO

// Add listener to document (DOM) so my DOM manipulation occurrs
// after the DOMContentLoaded event
document.addEventListener('DOMContentLoaded', onDomLoad);

// Code to execute when the DOM is ready
function onDomLoad() {

  // 1. Get element to listen for events
  const buttonEl = document.getElementById('my-button');
  const buttonEl2 = document.getElementById('my-button2');

  // 2. Add the listener and the event to listen for
  buttonEl.addEventListener('click', onButtonClick);
  buttonEl2.addEventListener('click', onButtonClick);
  buttonEl2.addEventListener('keyup', (event) => {
    console.log(`The key that was pressed/released was: ${event.key}`);

  });


  const sectionEl = document.getElementById('buttons');
  const mainEl = document.getElementById('main-content');
  const anchorEl = document.querySelector('a');
  const inputTextEl = document.getElementById('txt');
  const inputCheckboxEl = document.getElementById('chk');
  const formSubmitButtonEl = document.getElementById('btn-submit');

  addEventListenersToAncestorElemements(sectionEl, mainEl);
  addEventListenersToInputElements(inputTextEl, inputCheckboxEl);
  preventDefaultFormRequest(formSubmitButtonEl);
  preventDefaultAnchorLinking(anchorEl);
}

// 3. Define the callback to run when the event occurs
function onButtonClick(event) {
  const elementThatWasClicked = event.target;

  elementThatWasClicked.innerText = 'OUCH!';

  console.log(elementThatWasClicked.innerText);
  //alert(elementThatWasClicked.innerText);
}

/*
 * Add event listeners to the button parent elements
 * to listen for click events
 */
function addEventListenersToAncestorElemements(sectionEl, mainEl) {

  sectionEl.addEventListener('click', (event) => {
    console.log('<section> element clicked!');
  });

  mainEl.addEventListener('click', (event) => {
    console.log('<main> element clicked!');
    event.currentTarget.style.border = '5px solid black';
  });
}

/*
 * Add event listeners to form input elements
 */
function addEventListenersToInputElements(inputTextEl, inputCheckboxEl){

  inputTextEl.addEventListener('keyup', (event) => {
    if(event.key === 'Enter'){
      console.log(`The current text in the text field is: ${event.target.value}`)
    }
  });

  inputCheckboxEl.addEventListener('change', (event) => {
    console.log(`The current checkbox state is: ${event.target.checked}`)
  });
}

/* 
 * Use event.preventDefault() to stop the HTTP request that
 * occurs by default
 */
function preventDefaultFormRequest(formSubmitButtonEl){

  formSubmitButtonEl.addEventListener('click', (event) => {
    event.preventDefault();
  });
}

function preventDefaultAnchorLinking(anchorEl){

  anchorEl.addEventListener('click', (event) => {
    console.log('Anchor link clicked');
    event.preventDefault();
    console.log('Anchor link event handler finished');
  });
}