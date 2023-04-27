import axios from '../custom-axios/axios';

const BookShopService = {
    fetchAuthors: () => {
        return axios.get("/authors");
    },
    fetchBooks: () => {
        return axios.get("/books");
    },
    fetchCountries: () => {
        return axios.get("/countries");
    },
    fetchCategories: () => {
        return axios.get("/categories");
    },
    deleteBook: (id) => {
        return axios.delete(`/books/delete/${id}`);
    },
    addBook: (name, availableCopies, category, author) => {
        return axios.post("/books/add", {
            "name" : name,
            "availableCopies" : availableCopies,
            "category" : category,
            "author" : author
        })
    },
    editBook: (id, name, availableCopies, category, author) => {
        return axios.put(`/books/edit/${id}`,{
            "name" : name,
            "availableCopies" : availableCopies,
            "category" : category,
            "author" : author
            })
    },
    getBook: (id) => {
        return axios.get(`/books/${id}`);
    },
    markAsTaken: (id) => {
        return axios.put(`/books/mark/${id}`)
        // const book = this.getBook(id);
        // return axios.put(`/books/mark/${id}`, {
        //     "name": book.getName(),
        //     "availableCopies" : ,
        //     "category" : category,
        //     "author" : author
    }
}

export default BookShopService;