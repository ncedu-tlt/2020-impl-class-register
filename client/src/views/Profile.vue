<template>
  <div class="container">

    <div class="row">
      <div class="column left">
        <h2>Username: {{currentUser.username}}</h2>
        <img class="imgs" alt="photo.jpg" :src="currentUser.photo"/>


      </div>

      <div class="column middle">
        <div class="middleText">
          <h2>Student information</h2> <br>
          <p class="v-profile-id">Unique identity: {{currentUser.id}}</p>
          <p class="v-profile-id">FIO: {{currentUser.fio}}</p>
          <p class="v-profile-email">Email address: {{currentUser.email}}</p>
          <p class="v-profile-email">Date: {{currentUser.date}}</p>
          <p class="v-profile-email">Phone: {{currentUser.phone}}</p>
          <p class="v-profile-email">Address: {{currentUser.address}}</p>

          <form ref="uploadForm"  @submit.prevent="submit">
            <input type="file" ref="uploadImage" @change="onImageUpload()"/>
            <input v-if="formData != null" type="button" @click="startUpload" v-on:click="isHidden = false" name="Upload" value=" Upload "/>
            <template v-if="!isHidden">Attempt to upload a photo, log in again!</template>
          </form>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: 'Profile',
  data: () => ({
    formData: null,
    isHidden: true,
    id: '',
    username: '',
    password: '',
    email: ''
  }),
  methods: {

    onImageUpload() {
        let file = this.$refs.uploadImage.files[0];
        this.formData = new FormData();
        this.formData.append("file", file);
        this.formData.append("id", JSON.parse(localStorage.getItem('user')).id);
    },

    // rxjs
    // observable
    // subscribers

    startUpload() {
      let user = JSON.parse(localStorage.getItem('user'));
      axios({
        url: '/api/test/photo',
        method: 'POST',
        data: this.formData,
        headers: {
          Accept: 'application/json',
          'Content-Type': 'multipart/form-data',
          'Authorization': 'Bearer '.concat(user.accessToken)
        },
      }).then(response => {
        /* eslint-disable no-console */
        console.log(JSON.stringify(response.data));
        /* eslint-enable no-console */
      })
    }
  },
  computed: {
    currentUser() {
      return this.$store.state.auth.user;
    }
  },
  mounted() {
    if (!this.currentUser) {
      this.$router.push('/login');
    }
  }
};
</script>

<style scoped>
* {
  box-sizing: border-box;
}

.imgs {
  border-radius: 100%;
  width: 100%;
}

.row {
  margin-top: 20px;
}

.left {
  text-align: left;
}

.middleText {
  text-shadow: #2c3e50;
  display: block;
  margin-left: auto;
  margin-right: auto;
  width: 400px;
  text-align: left;
}

.leftText {
  text-shadow: #2c3e50;
  display: block;
  margin-left: auto;
  margin-right: auto;
  width: 280px;
  text-align: center;
}


.column {
  margin-top: 50px;
  border-radius: 10px;
  float: left;
  padding: 40px;
}

.left  {
  background-color: #7ec2f8;
  width: 25%;
}

.middle {
  margin-left: 10px;
  background-color: #6cb6f0;
  width: 73%;
}

/* Clear floats after the columns */
.row:after {
  content: "";
  display: table;
  clear: both;
}
</style>