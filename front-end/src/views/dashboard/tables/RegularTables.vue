<template>
  <v-container id="regular-tables" fluid tag="section">
    <base-v-component heading="Users Manager" link="components/simple-tables" />

    <base-material-card
      icon="mdi-clipboard-text"
      title="Simple Table"
      class="px-5 py-3"
    >
      <v-simple-table>
        <thead>
          <tr>
            <th class="primary--text">ID</th>
            <th class="primary--text">Name</th>
            <th class="primary--text">Country</th>
            <th class="primary--text">City</th>
            <th class="text-right primary--text">Salary</th>
          </tr>
        </thead>

        <tbody>
          <tr v-for="item in desserts" :key="item.name">
            <td>{{ item.name }}</td>
            <td>Users Manager</td>
            <td>Niger</td>
            <td>Oud-Turnhout</td>
            <td class="text-right">$36,738</td>
          </tr>
        </tbody>
      </v-simple-table>
    </base-material-card>
    <div class="py-3" />
  </v-container>
</template>
<script>
import axios from "axios";
export default {
  name: "RegularTables",
  data() {
    return {
      desserts: [
      ],
    };
  },
  mounted() {
    this.getPosts("");
  },
  methods: {
    getPosts(section) {
      let url = section;
      axios
        .get(url)
        .then((response) => {
          desserts = response.data.results;
        })
        .catch((error) => {
          console.log(error);
        });
    },
  },
};
</script>