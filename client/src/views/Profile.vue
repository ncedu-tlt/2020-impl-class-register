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
          <p class="v-profile-email">Email address: {{currentUser.email}}</p>

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

    startUpload() {
      let user = JSON.parse(localStorage.getItem('user'));
      axios({
        // url: 'https://secure-class-app.herokuapp.com/api/test/photo',
        url: 'http://localhost:8080/api/test/photo',
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
  height: 180px;
  width: 180px;
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
  float: left;
  padding: 60px;
  height: 550px; /* Should be removed. Only for demonstration */
}

.left  {
  background-color: #b8b8ff;
  width: 25%;
}

.middle {
  background-color: #a3a3ff;
  width: 75%;
}

/* Clear floats after the columns */
.row:after {
  content: "";
  display: table;
  clear: both;
}
</style>