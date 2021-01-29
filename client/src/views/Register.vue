<template>
  <div class="col-md-12">
    <div class="card card-container">

      <form name="form" @submit.prevent="handleRegister">
        <div v-if="!successful">

          <div class="form-group">
            <label for="fio">FIO</label>
            <input
                v-model="user.fio"
                v-validate="'required|min:3|max:30'"
                type="text"
                class="form-control"
                name="fio"
                placeholder="Ivanov Ivan Ivanovich"
                required
            />
            <div
                v-if="submitted && errors.has('fio')"
                class="alert-danger"
            >{{errors.first('fio')}}</div>
          </div>

          <div class="form-group">
            <label for="username">Username</label>
            <input
              v-model="user.username"
              v-validate="'required|min:3|max:14'"
              type="text"
              class="form-control"
              name="username"
              placeholder="Username"
              required
            />
            <div
              v-if="submitted && errors.has('username')"
              class="alert-danger"
            >{{errors.first('username')}}</div>
          </div>

          <div class="form-group">
            <label for="email">Email</label>
            <input
              v-model="user.email"
              v-validate="'required|email|max:50'"
              type="email"
              class="form-control"
              name="email"
              placeholder="Email@gmail.com"
              required
            />
            <div
              v-if="submitted && errors.has('email')"
              class="alert-danger"
            >{{errors.first('email')}}</div>
          </div>

          <div class="form-group">
            <label for="password">Password</label>
            <input
              v-model="user.password"
              v-validate="'required|min:6|max:40'"
              type="password"
              class="form-control"
              name="password"
              placeholder="Password"
              required
            />
            <div
              v-if="submitted && errors.has('password')"
              class="alert-danger"
            >{{errors.first('password')}}</div>
          </div>

          <div class="form-group">
            <label for="date">Date</label>
            <input
                type="date"
                v-model="user.date"
                value="2018-07-22"
                min="2018-01-01"
                max="2021-01-01"
                class="form-control"
                name="date"
                required
            />
            <div
                v-if="submitted && errors.has('date')"
                class="alert-danger"
            >{{errors.first('date')}}</div>
          </div>

          <div class="form-group">
            <label for="phone">Phone</label>
            <input
                type="tel"
                placeholder="89277878489"
                v-validate="'required|min:11|max:11'"
                v-model="user.phone"
                name="phone"
                pattern="[7-8]{1}[0-9]{3}[0-9]{3}[0-9]{4}"
                class="form-control"
                required
            />
            <div
                v-if="submitted && errors.has('phone')"
                class="alert-danger"
            >{{errors.first('phone')}}</div>
          </div>

          <div class="form-group">
            <label for="address">School address</label>
            <select class="form-control" v-model="user.address" required>
<!--              <option disabled value="Choose one"></option>-->
              <option defa>Улица Карла-Маркса 32, кв 120</option>
            </select>
            <div
                v-if="submitted && errors.has('address')"
                class="alert-danger"
            >{{errors.first('address')}}</div>
          </div>

          <div class="form-group">
            <button class="btn btn-primary btn-block">Sign Up</button>
          </div>
        </div>
      </form>

      <div
        v-if="message"
        class="alert"
        :class="successful ? 'alert-success' : 'alert-danger'"
      >{{message}}</div>
    </div>
  </div>
</template>

<script>
import User from '../models/user';

export default {
  name: 'Register',
  data() {
    return {
      user: new User('', '', '', '', '', ''),
      submitted: false,
      successful: false,
      message: ''
    };
  },
  computed: {
    loggedIn() {
      return this.$store.state.auth.status.loggedIn;
    }
  },
  mounted() {
    if (this.loggedIn) {
      this.$router.push('/profile');
    }
  },
  methods: {
    handleRegister() {
      this.message = '';
      this.submitted = true;
      this.$validator.validate().then(isValid => {
        if (isValid) {
          this.$store.dispatch('auth/register', this.user).then(
            data => {
              this.message = data.message;
              this.successful = true;
            },
            error => {
              this.message =
                (error.response && error.response.data && error.response.data.message) ||
                error.message ||
                error.toString();
              this.successful = false;
            }
          );
        }
      });
    }
  }
};
</script>

<style scoped>
label {
  display: block;
}

.card-container.card {
  top: 10px;
  max-width: 350px !important;
  padding-bottom: 0px;
  padding-top: 10px;
  line-height: 1;
  position: center;
}

.card {
  line-height: 1;
  background-color: #f7f7f7;
  padding: 20px 25px 30px;
  margin: 0 auto;
  -moz-border-radius: 2px;
  -webkit-border-radius: 2px;
  border-radius: 2px;
  -moz-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
  -webkit-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
  box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
}


.profile-img-card {
  width: 96px;
  height: 96px;
  margin: 0 auto 10px;
  display: block;
  -moz-border-radius: 50%;
  -webkit-border-radius: 50%;
  border-radius: 50%;
}
</style>