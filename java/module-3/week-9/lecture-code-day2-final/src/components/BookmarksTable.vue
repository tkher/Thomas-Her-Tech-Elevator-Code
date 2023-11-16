<template >
  <!-- Public bookmarks Table -->
  <div id="view-content">
    <table id="table-bookmarks" v-if="bookmarkData && bookmarkData.length > 0">
      <thead>
        <tr>
          <th>Link</th>
          <th>Description</th>
          <th>Tags</th>
          <th>User</th>
          <th v-if="canAdd">&nbsp;</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="eachBookmark in filteredBookmarks"
            v-bind:key="eachBookmark.bookmarkId" >
          <td><a v-bind:href="eachBookmark.url" target="_blank">{{ eachBookmark.title }}</a></td>
          <td v-on:click="onDescriptionClick(eachBookmark.description)">{{ eachBookmark.description }}</td>
          <td>{{ eachBookmark.allTags }}</td>
          <td><a href="#">{{ eachBookmark.userDisplayName }}</a></td>
          <td v-if="canAdd">
            <div class="icon-button" title="Add bookmark" v-on:click="onAddBookmark(eachBookmark)">
              <font-awesome-icon class="icon" icon="fa-solid fa-cart-plus" />
            </div>
          </td>
        </tr>
      </tbody>
    </table>
    <h4 v-else>There are no bookmarks!</h4>
  </div>
</template>

<script>
import BookmarkService from "../services/BookmarkService";

export default {
  props: ['bookmarkData', 'canAdd'],
  computed: {
    filteredBookmarks() {

      const searchTerm = this.$store.state.searchTerm.toLowerCase();
      if(!searchTerm) return this.bookmarkData;

      return this.bookmarkData.filter((eachBookmark) => {
        const title = eachBookmark.title.toLowerCase();

        return title.includes(searchTerm);
      });
    }
  },
  methods: {
    onDescriptionClick(bookmarkDescription){
      this.$store.commit('SET_DESCRIPTION_MESSAGE', bookmarkDescription);
    },
    onAddBookmark(bookmark){
      BookmarkService
        .addNewBookmark(bookmark)
        .then(window.alert('new bookmark added'))
        .catch( (error) => {
          window.alert(`ERROR: ${error}`);
        })
    }
  },
}
</script>

<style scoped>
.icon {
  cursor: pointer;
}

#view-content {
  width: 90%;
}

#table-bookmarks {
  padding-left: 30px;
  width: 100%;
}

thead {
  background-color: aquamarine;
  box-shadow: 0 0 0 1px rgba(0, 0, 0, 0.25);
}

tbody {
  box-shadow: 0 0 0 1px rgba(0, 0, 0, 0.25);
}

tbody > tr:nth-child(odd){
  background-color: lightcyan;
}
.view-icon {
  font-size: 1.2rem;
  margin-right: 7px;
  padding: 3px;
  color: #444;
  border-radius: 3px;
}

.view-icon.active {
  background-color: lightgreen;
}

.view-icon:not(.active) {
  font-size: 1.2rem;
  margin-right: 7px;
  cursor: pointer;
}

.view-icon:not(.active):hover {
  color: blue;
  background-color: rgba(255, 255, 255, 0.7);
}


</style>