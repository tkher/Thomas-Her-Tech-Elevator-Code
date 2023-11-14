function initialize() {
  // Hook up the search box event handler
  document.getElementById("search-tb").addEventListener('keyup', displayRows);

  // Hook up the event handler to close a message when clicked
  document.getElementById("message-bar").addEventListener('click', clearMessage);

  displayRows();
}

function getBookmarksList() {
  const searchValue = document.getElementById("search-tb").value;
  if (searchValue) {
      return bookmarkService.searchBookmarks(searchValue);
  } else {
      return bookmarkService.getBookmarks();
  }
}

function displayRows() {
  // Get the list of products from the service
  const bookmarks = getBookmarksList();

  // Get the section that will contain all the cards
  const tbodyEl = document.querySelector("#table-public-bookmarks > tbody");

  // Clear its current contents
  tbodyEl.innerHTML = "";

  // Loop through the list and build cards
  for (let eachBookmark of bookmarks) {
      const rowEl = createRow(eachBookmark);
      tbodyEl.appendChild(rowEl);
  }
}

/*
<tr>
<td><a href="#" target="_blank">My Link</a></td>
<td>Bookmark Description</td>
<td>Bookmark Tags</td>
<td><a href="#">A. User</a></td>
<td>
  <div class="icon-button" title="Reported as inappropriate">
    <i class="fa-solid fa-triangle-exclamation"></i>
  </div>
</td>
</tr>
*/
function createRow(bookmarkObj) {

  // First the row
  const rowEl = document.createElement("tr");

  const tdLinkEl = document.createElement("td");
  const anchorEl = document.createElement("a");
  anchorEl.setAttribute('href', "#");
  anchorEl.setAttribute('target', "_blank");
  anchorEl.innerText = bookmarkObj.title;
  tdLinkEl.appendChild(anchorEl);

  const tdDescriptionEl = document.createElement("td");
  tdDescriptionEl.innerText = bookmarkObj.description;
  tdDescriptionEl.addEventListener('click', () => {
    showMessage(bookmarkObj.description);
  });

  const tdTagsEl = document.createElement("td");
  tdTagsEl.innerText = '-Tags-';

  const tdUserEl = document.createElement("td");
  const userAnchorEl = document.createElement("a");
  userAnchorEl.setAttribute('href', "#");
  userAnchorEl.innerText = 'A. User';
  tdUserEl.appendChild(userAnchorEl);

  const tdIconEl = document.createElement("td");
  const divIconEl = document.createElement("div");
  divIconEl.setAttribute('class', 'icon-button');
  divIconEl.setAttribute('title', 'Reported as inappropriate');
  const iconEl = document.createElement('i');
  iconEl.setAttribute('class', "fa-solid fa-triangle-exclamation");

  divIconEl.appendChild(iconEl);
  tdIconEl.appendChild(divIconEl);

  rowEl.appendChild(tdLinkEl);
  rowEl.appendChild(tdDescriptionEl);
  rowEl.appendChild(tdTagsEl);
  rowEl.appendChild(tdUserEl);
  rowEl.appendChild(tdIconEl);

  return rowEl;
}

// When the user clicks on an item, show the description in the message bar
function showDescription(ev) {
  // Get the id of the target
  const id = Number(ev.currentTarget.getAttribute("data-id"));
  // Get the product
  const product = bookmarkService.getBookmarkById(id);
  // Add message
  if (product) {
      showMessage(product.description);
  }
}

function showMessage(msg) {
  const messageDiv = document.getElementById("message-bar").children[0];
  messageDiv.innerText = msg;
  messageDiv.style.backgroundColor = 'lightgreen';
  messageDiv.style.visibility = "visible";
}

function clearMessage() {
  const messageDiv = document.getElementById("message-bar").children[0];
  messageDiv.innerText = "";
  messageDiv.style.backgroundColor = '';
  messageDiv.style.visibility = "hidden";
}

// When this script loads, hook up to DOMContentLoaded
document.addEventListener('DOMContentLoaded', initialize);
