<template>
  <div>
    <h1>Library Catalog</h1>
    <ul>
      <li v-for="book in books" :key="book.id">
        {{ book.title }} by {{ book.author }}
        <button @click="orderBook(book.id)">Order</button>
      </li>
    </ul>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      books: []
    };
  },
  mounted() {
    this.fetchBooks();
  },
  methods: {
    fetchBooks() {
      axios.get('/api/books')
        .then(response => {
          this.books = response.data;
        })
        .catch(error => {
          console.error('Error fetching books:', error);
        });
    },
    orderBook(bookId) {
      const readerId = 1; 
      axios.post('/api/orders', { bookId, readerId })
        .then(() => {
          console.log('Book ordered successfully');
        })
        .catch(error => {
          console.error('Error ordering book:', error);
        });
    }
  }
};
</script>
