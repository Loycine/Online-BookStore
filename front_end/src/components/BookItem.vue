<template>
  <article class="book">
    <figure class="book-image">
      <router-link
        :to="{name: 'Book', params: {id: book.id}}"
        >
        <img 
        :src="book.images.medium" 
        :alt="book.title">
      </router-link>
      <figcaption>
        <p class="price"> 
          {{ book.price }}
      </p>
      </figcaption>
    </figure>
    <section class="book-info">
      <h3 class="title">
        <router-link
          :to="{name: 'Book', params: {id: book.id}}"
          >
          {{ book.title }}
        </router-link>
      </h3>
      <p class="author"> {{ book.author }} </p>
      <p class="summary"> {{ book.summary }} </p>
      <p class="actions">
        <button-buy-book :book="book"></button-buy-book>
      </p>
    </section>
  </article>
</template>

<script>
  import ButtonBuyBook from '@/components/ButtonBuyBook'

  export default {
    name: 'BookItem',

    components: {
      ButtonBuyBook
    },

    props: {
      book: Object
    }
  }
</script>

<style lang="scss" scoped>
@import '../assets/styles/common';

.book {
  display: flex;
  padding: .5rem;
  margin-bottom: 1rem;
}

.book-image {
  padding: 0 .5rem;

  img {
    width: 96px;
    height: 128px;
  }

  .price {
    text-align: center;
  }
}

.book-info {
  display: flex;
  flex: 1 1 auto;
  flex-direction: column;
  padding: 0 .5rem;
  overflow: hidden;

  .title {
    padding: .2rem 0;
    a {
      color: #613f23;
    }
  }

  p {
    padding: .2em 0;
    font-size: .8em;
    line-height: 1.3;
  }

  .summary {
    @extend %text-ellipsis;
  }

  .actions {
    margin-top: auto;
  }
}
</style>

