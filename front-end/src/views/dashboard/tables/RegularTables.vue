<template>
  <v-container id="regular-tables" fluid tag="section">
    <!-- <base-v-component heading="Users Manager" link="components/simple-tables" /> -->

    <!-- <base-material-card
      icon="mdi-clipboard-text"
      title="Simple Table"
      class="px-5 py-3"
    > -->
      <v-simple-table>
        <thead>
          <tr>
            <th class="primary--text title">User Name</th></th>
            <th class="primary--text title">Active</th>
            <th class="primary--text title">Add</th>
            <th class="primary--text title">Edit</th>
            <th class="text-right primary--text title">Delete</th>
          </tr>
        </thead>

        <tbody>
          <tr v-for="item in desserts" :key="item.name">
            <td>{{ item.username }}</td>
            <td class="bnt">{{item.active==1?'active':'inactive'}}</td>
            <td class="bnt">
              <v-btn color="primary ">
               add
              </v-btn>
            </td>
            <td class="bnt">
              <v-btn  color="primary"> Edit </v-btn>
            </td>
            <td class="bnt">
              <v-btn depressed color="error"> Delete </v-btn>
            </td>
          </tr>
        </tbody>
      </v-simple-table>
    <div class="py-3" />
  </v-container>
</template>
<script>
import axios from "axios";
export default {
  name: "RegularTables",
  data() {
    return {
      desserts: [],
    };
  },
  mounted() {
    this.getPosts("http://localhost:9999/user/findUser");
  },
  methods: {
    getPosts(section) {
      let url = section;
      axios
        .get(url)
        .then((response) => {
          this.desserts = response.data.data;
          console.log(this.desserts);
        })
        .catch((error) => {
          console.log(error);
        });
    },
  },
};
</script>
<style scoped>
button {
  height: 30px !important;
  width: 40px !important;
}
.primary--text {
  font-size: 17px !important;
  text-align: center !important;
}
.title {
  color: brown;
}
.bnt {
  text-align: center !important;
}
</style>