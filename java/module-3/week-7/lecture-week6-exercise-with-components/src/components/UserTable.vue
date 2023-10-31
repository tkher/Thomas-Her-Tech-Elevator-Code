<template>
  <table id="tblUsers">
    <thead>
      <tr>
        <th>&nbsp;</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Username</th>
        <th>Email Address</th>
        <th>Status</th>
        <th>Actions</th>
      </tr>
    </thead>
    <tbody>
      <filters-row />
      <user-row
        v-for="user in filteredList"
        v-bind:key="user.id"
        v-bind:class="{ deactivated: user.status === 'Inactive' }"
        v-bind:user="user"
      />
    </tbody>
  </table>

  {{ $store.state.selectedUserIDs }}
</template>

<script>
import FiltersRow from "./UserTableFilters.vue";
import UserRow from "./UserTableRow.vue";

export default {
  components: { FiltersRow, UserRow },
  computed: {
    filteredList() {
      let filteredUsers = this.$store.state.users;
      if (this.$store.state.filter.firstName != "") {
        filteredUsers = filteredUsers.filter((user) =>
          user.firstName
            .toLowerCase()
            .includes(this.$store.state.filter.firstName.toLowerCase())
        );
      }
      if (this.$store.state.filter.lastName != "") {
        filteredUsers = filteredUsers.filter((user) =>
          user.lastName
            .toLowerCase()
            .includes(this.$store.state.filter.lastName.toLowerCase())
        );
      }
      if (this.$store.state.filter.username != "") {
        filteredUsers = filteredUsers.filter((user) =>
          user.username
            .toLowerCase()
            .includes(this.$store.state.filter.username.toLowerCase())
        );
      }
      if (this.$store.state.filter.emailAddress != "") {
        filteredUsers = filteredUsers.filter((user) =>
          user.emailAddress
            .toLowerCase()
            .includes(this.$store.state.filter.emailAddress.toLowerCase())
        );
      }
      if (this.$store.state.filter.status != "") {
        filteredUsers = filteredUsers.filter((user) =>
          user.status === this.$store.state.filter.status
        );
      }
      return filteredUsers;
    }
  }
};
</script>

<style scoped>
table {
  margin-top: 20px;
  font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Oxygen,
    Ubuntu, Cantarell, "Open Sans", "Helvetica Neue", sans-serif;
  margin-bottom: 20px;
}
th {
  text-transform: uppercase;
}
td {
  padding: 10px;
}
tr.deactivated {
  color: red;
}
</style>