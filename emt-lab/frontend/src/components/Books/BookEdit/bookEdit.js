import React from "react";
import { useNavigate } from 'react-router-dom';

const BookEdit = (props) => {

    const navigate = useNavigate();
    const [formData, updateFormData] = React.useState({
        name: "",
        availableCopies: 0,
        category: "NOVEL",
        author: 1
    })

    const handleChange = (e) => {
        updateFormData({
            ...formData,
            [e.target.name]: e.target.value
        })
    }

    const onFormSubmit = (e) => {
        e.preventDefault();
        const name = formData.name !== "" ? formData.name : props.book.name;
        const availableCopies = formData.availableCopies !== 0 ? formData.availableCopies : props.book.availableCopies;
        const category = formData.category !== "NOVEL" ? formData.category : props.book.category;
        const author = formData.author !== 1 ? formData.author : props.book.author.id;

        props.onEditBook(props.book.id, name, availableCopies, category, author);
        navigate("/books", { replace: true })
    }

    return (
        <div className="row mt-5">
            <div className="col-md-5">
                <form onSubmit={onFormSubmit}>
                    <div className="form-group">
                        <label htmlFor="name">Book name</label>
                        <input type="text"
                               className="form-control"
                               id="name"
                               name="name"
                               required
                               placeholder={props.book.name}
                               onChange={handleChange}
                        />
                    </div>
                    <div className="form-group">
                        <label htmlFor="availableCopies">Available Copies</label>
                        <input type="text"
                               className="form-control"
                               id="availableCopies"
                               name="availableCopies"
                               placeholder={props.book.availableCopies}
                               required
                               onChange={handleChange}
                        />
                    </div>
                    <div className="form-group">
                        <label>Category</label>
                        <select name="category" className="form-control" onChange={handleChange}>
                            {props.categories.map((category) => {
                                if (props.book.category !== undefined &&
                                    props.book.category === category)
                                    return <option value={category} selected={category}>{category}</option>
                                else return <option value={category}>{category}</option>
                               }
                            )}
                        </select>
                    </div>
                    <div className="form-group">
                        <label>Author</label>
                        <select name="author" className="form-control" onChange={handleChange}>
                            {props.authors.map((author) => {
                                if (props.book.author !== undefined &&
                                    props.book.author.id === author.id)
                                    return <option selected={props.book.author.id} value={author.id}>{author.name} {author.surname}</option>
                                else return <option value={author.id}>{author.name} {author.surname}</option>
                                }
                            )}
                        </select>
                    </div>
                    <button id="submit" type="submit" className="btn btn-primary">Submit</button>
                </form>
            </div>
        </div>

    )
}

export default BookEdit;