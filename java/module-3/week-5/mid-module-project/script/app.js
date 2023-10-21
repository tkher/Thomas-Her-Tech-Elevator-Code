//Step 7 - Build Card data
/* replace hard coded html with data from productService. */

document.addEventListener('DOMContentLoaded', () => {

//Generate all products
const allProducts = productService.getProducts();

//***Select Statements***
const productCards = document.getElementById('product-cards');
    //select product cards
const productCardList = document.querySelectorAll('.product-card');


//remove HTML hard coded-products
function deleteHtmlProds() {
   productCards.innerText = "";
}
deleteHtmlProds();


//create a product-card object
function addProductCardObject () {
    let newProductCard = document.createElement('article');
    newProductCard.setAttribute('class', 'product-card');
    productCards.appendChild(newProductCard);

    let newSku= document.createElement('div');
    newSku.setAttribute('class', 'sku');
    newProductCard.appendChild(newSku);

    let newPrice=document.createElement('div');
    newPrice.setAttribute('class', 'price');
    newProductCard.appendChild(newPrice);

    const newProductName=document.createElement('div');
    newProductName.setAttribute('class', 'product-name action')
    newProductName.setAttribute('data-id', '0') //data-id default to 0
    newProductCard.appendChild(newProductName);
    
    const newProductImg=document.createElement('div');
    newProductImg.setAttribute('class', 'product-image');
    const newProductImgSrc=document.createElement('img');
    newProductImgSrc.setAttribute('src', ''); //default to blank src
    newProductImg.appendChild(newProductImgSrc);
    newProductCard.appendChild(newProductImg);

    const newCart=document.createElement('cart');
    newCart.setAttribute('class', 'cart');
    const newCartIcon=document.createElement('i');
    newCartIcon.setAttribute('class', 'fa-solid fa-cart-plus icon action');
    newCartIcon.setAttribute('title', 'Add item to cart');
    newCart.appendChild(newCartIcon);
    newProductCard.appendChild(newCart);
}
//addProductCardObject();   Do not need to run 

//creates a blank array of productCardList the size of allProduct list
function setSizeOfProdList() {
    for (let i=0; i < allProducts.length; i++) {
        addProductCardObject();
    }
}
setSizeOfProdList();


//Assign all item in allProducts to productCardList
function addProductsToList() {
    const productCardList = document.querySelectorAll('.product-card');
    for (let i=0; i < productCardList.length; i++) {
        productCardList[i].children[0].innerText = allProducts[i].productSku;
        productCardList[i].children[1].innerText = "$" + allProducts[i].price;
        productCardList[i].children[2].innerText = allProducts[i].name;
        productCardList[i].children[2].setAttribute('data-id', allProducts[i].productId);
        productCardList[i].children[3].children[0].setAttribute('src', allProducts[i].imageName);
        
    }
}

addProductsToList();

//**step 8 */
//Add event handlier for shopping Cart
//create window-Alert




//event handlier
const toggleCart = document.querySelectorAll('.cart');
toggleCart.addEventListener('click', () => {
    
})


});












//************************UN-USED CODE: TO DELETE***************************/
//***********************test area********************

console.log(productCardList[0].children[3].children[0]);


//gets the 1st attribute
const test = productCardList[0].children[0].getAttribute('class');

// **This selected ths sku of the 1st item
//productCardList[0].children[0]

//changes the value of the sku
//productCardList[0].children[0].innerText = 'SKU-999';

//run functions
    //deleteHtmlProds();



/*This works
//add to prod list. So far This replaces product card list with all products list. 
function addToProdList() {
    for (let i=0; i < productCardList.length; i++) {
        productCardList[i].children[0].innerText = allProducts[i].productSku;
        
    }
}

addToProdList();
*/


/* Test HTML code 
const prodOne = productCardList[0];

//classes of hardCoded HTML Products

const sku= prodOne.children[0];
const price= prodOne.children[1];
const prodName=prodOne.children[2];
const image=prodOne.children[3];




function createItem() {
    let newProductCard = document.createElement(article);
    newProductCard.setAttribute('class', 'product-card');
    productCards.appendChild(newProductCard);

    let newSku= document.createElement(div);
    newSku.setAttribute('class', 'sku');
}


*/