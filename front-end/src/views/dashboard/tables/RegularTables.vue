<template>
  <v-container id="regular-tables" fluid tag="section">
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
              <v-btn  color="primary"  @click="editUser(item)"> Edit </v-btn>
            </td>
            <td class="bnt">
              <v-btn depressed color="error"> Delete </v-btn>
            </td>
          </tr>
        </tbody>
      </v-simple-table>
      <!-- pop up dialog start-->
  <div>
    <v-row justify="center">
    <v-dialog v-model="dialog" persistent max-width="600px">
      <v-card>
        <v-card-title>
          <span class="headline">User Profile</span>
        </v-card-title>
        <v-card-text>
          <v-container>
            <v-row>
              <v-col cols="12">
                <v-text-field 
                label="Email*"
                v-model="this.user.email"
                 required>
                 </v-text-field>
              </v-col>
              <v-col cols="12">
                <v-text-field
                  label="Password*"
                  type="password"
                  required
                ></v-text-field>
              </v-col>
              <v-col cols="12" sm="6">
                <v-select
                  :items="['0-17', '18-29', '30-54', '54+']"
                  label="Trạng thái*"
                  required
                ></v-select>
              </v-col>
              <v-col cols="12" sm="6">
                <v-autocomplete
                  :items="[
                    'Skiing',
                    'Ice hockey',
                    'Soccer',
                    'Basketball',
                    'Hockey',
                    'Reading',
                    'Writing',
                    'Coding',
                    'Basejump',
                  ]"
                  label="Role"
                  multiple
                ></v-autocomplete>
              </v-col>
            </v-row>
          </v-container>
          <!-- <small>*indicates required field</small> -->
        </v-card-text>
        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn color="blue darken-1" text  @click="dialog= false">
            Close
          </v-btn>
          <v-btn color="blue darken-1" text @click="save()">
            Save
          </v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>   
  </v-row>
  <!-- pop up dialog end -->
</div>
    <div class="py-3" />
  </v-container>
</template>
<script>
import axios from "axios";
import UserDialog from "./UserDialog";
export default {
  components: {
    UserDialog,
  },
  name: "RegularTables",
  data() {
    return {
      desserts: [],
      showDialog: true,
      user: {},
      dialog: false,
      userRole: {},
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
    getUser(userId) {
      axios
        .get("http://localhost:9999/user/findUser")
        .then((response) => {
          this.desserts = response.data.data;
          console.log(this.desserts);
        })
        .catch((error) => {
          console.log(error);
        });
    },
    editUser(user) {
      this.dialog = true;
      console.log(user);
    },
    save() {
      console.log("this the save value ", this.user.email);
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