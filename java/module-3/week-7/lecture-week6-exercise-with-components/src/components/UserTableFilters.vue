<template>
  <tr>
    <td>
      <input type="checkbox" id="selectAll" v-on:change="selectAll($event)"
        v-bind:checked="$store.state.selectedUserIDs.length === $store.state.users.length" />
    </td>
    <td>
      <input type="text" id="firstNameFilter" v-model="firstName" />
    </td>
    <td>
      <input type="text" id="lastNameFilter" v-model="lastName" />
    </td>
    <td>
      <input type="text" id="usernameFilter" v-model="username" />
    </td>
    <td>
      <input type="text" id="emailFilter" v-model="emailAddress" />
    </td>
    <td>
      <select id="statusFilter" v-model="status">
        <option value>Show All</option>
        <option value="Active">Active</option>
        <option value="Inactive">Inactive</option>
      </select>
    </td>
    <td>&nbsp;</td>
  </tr>
</template>

<script>
export default {
  props: {
    selectedUserIDs: Array
  },
  methods: {
    selectAll(event) {
      this.$store.commit('SELECT_ALL_IDS', event.target.checked);
    }   
  },
  computed: {
    firstName: {
      get() {
        return this.$store.state.filter.firstName;
      },
      set(value) {
        this.$store.commit('SET_FILTER_FIRST_NAME', value)
      }
    },
    lastName: {
      get() {
        return this.$store.state.filter.lastName;
      },
      set(value) {
        this.$store.commit('SET_FILTER_LAST_NAME', value)
      }
    },
    username: {
      get() {
        return this.$store.state.filter.username;
      },
      set(value) {
        this.$store.commit('SET_FILTER_USERNAME', value)
      }
    },
    emailAddress: {
      get() {
        return this.$store.state.filter.emailAddress;
      },
      set(value) {
        this.$store.commit('SET_FILTER_EMAIL', value)
      }
    },
    status: {
      get() {
        return this.$store.state.filter.status;
      },
      set(value) {
        this.$store.commit('SET_FILTER_STATUS', value)
      }
    }
  }
};
</script>

<style scoped></style>