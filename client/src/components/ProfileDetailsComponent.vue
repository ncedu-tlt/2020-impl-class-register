<template>
  <div class="profile-details__wrapper">
    <div class="profile-details__item">
      <div class="profile-details__item-label">
        Full name:
      </div>
      <div class="profile-details__item-text">
        {{ fullname }}
      </div>
    </div>
    <div class="profile-details__item">
      <div class="profile-details__item-label">
        Age :
      </div>
      <div class="profile-details__item-text">
        <button @click="decrease()">-</button>
         {{userAge}}
        <button @click="increase()">+</button>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "ProfileDetailsComponent",
  props: {
    name: String,
    lastName: String,
    age: Number
  },
  data: () => ({
    userAge: 0
  }),
  computed: {
    fullname() {
      return this.name + ' ' + this.lastName;
    }
  },
  methods: {
    increase() {
      this.userAge++
    },
    decrease() {
      if (this.userAge > 0) {
        this.userAge--
      }
    }
  },
  beforeMount() {
    this.$nextTick(() => {
      this.userAge = this.age;
    })
  }
}
</script>

<style scoped lang="less">
.profile-details {

  &__wrapper {

  }

  &__item {
    flex-direction: row;
    display: flex;
    margin: 0 auto;
    justify-content: center;
    font-size: 24px;
    line-height: 24px;

    &-label {

    }

    &-text {
      margin-left: 16px;
    }
  }
}
</style>
