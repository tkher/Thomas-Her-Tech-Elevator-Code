window.addEventListener('DOMContentLoaded', onDomLoad);


function onDomLoad() {
  // const introEl = document.getElementById('intro');
  // introEl.innerHTML = 'I dedicate this page to my <span>cat</span>';
  // console.log(`introEl is: ${introEl}`);
  // console.log(`introEl.innterText is: ${introEl.innerText}`);
  // console.log(`introEl.id is: ${introEl.id}`);

  // const contentEl = document.querySelector('.content');
  // console.log(`contentEl is: ${contentEl}`);
  // console.log(`contentEl.innerText is: ${contentEl.innerText}`);

  const contentElements = document.querySelectorAll('.content');
  console.log(`contentElements is: ${contentElements}`);

  //const colorGreen = 0x00FF00;
  
  for(let i = 0; i < contentElements.length; i++){
    const eachEl = contentElements[i];
    eachEl.style.color = 'rgb(0,255,0)';
    console.log(`eachEl.innerText is: ${eachEl.innerText}`);
  }

  // Create new <p> element
  const newPElement = document.createElement('p');
  newPElement.innerText = "this is a new <p> element";
  newPElement.setAttribute('class', 'new-elements');
  // newPElement.setAttribute('class', 'another-new-element');
  newPElement.classList.add('another-new-element');

  // Select parent element where I want the new <p>
  // element to be inserted into the DOM
  document.body.insertAdjacentElement('afterbegin', newPElement);
}


/*

const newLiEl = document.createElement('li');
newLiEl.innerText = "Hey look, I'm adding a new <li>!";
newLiEl.setAttribute('class', 'importantStuff');
newLiEl.classList.add('moreImportantStuff');
//newLiEl.classList.remove('importantStuff');

const parentEl = document.getElementById('theList');
//parentEl.appendChild(newLiEl);
parentEl.insertAdjacentElement('beforebegin', newLiEl);
console.log();
*/