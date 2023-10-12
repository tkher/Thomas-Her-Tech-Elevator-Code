/*
 * https://developer.mozilla.org/en-US/docs/Web/API/fetch
 */
const API_BASE = 'http://localhost:8080';
const PRODUCTS_ENDPOINT = `${API_BASE}/products`;
const CART_ENDPOINT = `${API_BASE}/cart`;
const BEARER_TOKEN = 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyIiwiYXV0aCI6IlJPTEVfVVNFUiIsImV4cCI6MTY5NzE0MDk2NH0.yK3PtoTkmKD6jAAG4gm0XQn86iwqiQzTD5X6CUuTXiS9db9iZB2V88rSDHci1Z6MqtUyXpG-8ihCLNf1z1DcRA';


/*
 * Only attach listeners to elements after DOM
 * loads when all DOM nodes are available
 */
document.addEventListener('DOMContentLoaded', () => {
  addButtonListeners();
});

function addButtonListeners(){
  document.getElementById('btn-get').addEventListener('click', onGetProduct);
  document.getElementById('btn-get-id').addEventListener('click', onGetProductById);
  document.getElementById('btn-get-cart').addEventListener('click', onGetCart);
  document.getElementById('btn-post').addEventListener('click', onPostCart);
  document.getElementById('btn-put').addEventListener('click', onPutCart);
  document.getElementById('btn-delete').addEventListener('click', onDeleteCart);
  document.getElementById('api-accordion-btn').addEventListener('click', removeChildLiElements);
};

function onGetProduct(){

  // For GET requests, the following is optional, { method: 'GET' }
  fetch(PRODUCTS_ENDPOINT, { method: 'GET' })
  .then( response => {
    console.log(`response: ${response}`);
    return response.json();
  })
  .then( data => {
    console.log(`data: ${data}`);
    displayData(data);
    return data;
  })
  .catch(error => {
    console.error('error ', error)
  });

  /*
   * This will execute before the API request completes
   */
  console.log('This print occurs after the promise calls');
}

function onGetProductById(){

  const inputEl = document.getElementById('product-id-input');
  const productId = inputEl.value;
  
  if(!productId){
    console.error('ERROR: Invalid product id: ${productId}');
    return;
  }

  fetch(`${PRODUCTS_ENDPOINT}/${productId}`)
  .then((response) => {
    return response.json();
  })
  .then((data) => {
    displayData(data);
  })
  .catch(error => {
    console.log('error ', error)
  });
}

function onGetCart(){

  fetch(CART_ENDPOINT, {
    headers: {
      'Authorization': `Bearer ${BEARER_TOKEN}`,
      'Content-type': 'application/json',
    }
  })
  .then((response) => {
    return response.json();
  })
  .then((data) => {
    displayData(data);
  })
  .catch(error => {
    console.log('error ', error)
  });
}

function onPostCart(){

  const prodId = document.getElementById('cart-product-id-input').value;
  const productQuantity = document.getElementById('cart-quantity-input').value;

  const postData = {
    cartItemId: 1,
    userId: 1,
    productId: prodId,
    quantity: productQuantity
  };

  fetch(`${CART_ENDPOINT}/items`, {
    method: 'POST',
    headers: {
      'Authorization': `Bearer ${BEARER_TOKEN}`,
      'Content-type': 'application/json',
    },
    body: JSON.stringify(postData)
  })
  .then((response) => {
    return response.json();
  })
  .then((data) => {
    displayData(data);
  })
  .catch(error => {
    console.log('error ', error)
  });
}

/* TODO: Not implemented on the server yet */
function onPutCart(){}

function onDeleteCart(){

  fetch(CART_ENDPOINT, {
    method: 'DELETE',
    headers: {
      'Authorization': `Bearer ${BEARER_TOKEN}`,
      'Content-type': 'application/json',
    }
  })
  .then((response) => {
    window.alert('cart deleted!');
  })
  .catch(error => {
    console.log('error ', error)
  });
}

function removeChildLiElements(){
  const parentEl = document.getElementById('returned-data-ul');

  while( parentEl.firstChild ){
    parentEl.removeChild( parentEl.firstChild );
  }

  return parentEl;
}

function displayData(data){

  const ulEl = removeChildLiElements();

  if( Array.isArray(data) ){
    data.forEach( eachData => addLiObject(ulEl, eachData) );
  } else {
    addLiObject(ulEl, data);
  }
}

function addLiObject(parent, eachData){
  const eachLiEl = document.createElement('li');
  eachLiEl.innerText = getObjStr(eachData);
  parent.insertAdjacentElement('beforeend', eachLiEl);
}

// Didn't like the look of JSON.stringify()
function getObjStr(object){
  const objStr = [];

  for(let key in object){
    objStr.push(`${key}: ${object[key]}`);
  }

  return objStr.join('\n');
}