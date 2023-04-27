import React from "react";
import {Link} from 'react-router-dom';

const bookTerm = (props) => {

    return (
        <tr>
            <td>{props.term.name}</td>
            <td>{props.term.availableCopies}</td>
            <td>{props.term.category}</td>
            <td>{props.term.author.name} {props.term.author.surname}</td>
            <td scope={"col"} className={"text-right"}>
                <a title={"Delete"} className={"btn btn-danger"}
                    onClick={() => props.onDelete(props.term.id)}>
                    Delete
                </a>
                <Link className={"btn btn-info ms-3"}
                      onClick={() => props.onEdit(props.term.id)}
                      to={`/books/edit/${props.term.id}`}>
                      Edit
                </Link>
                <Link className={"btn btn-info ms-3"}
                      to={`/books/mark/${props.term.id}`}
                      state={{id: props.term.id ,availableCopies: props.term.availableCopies }}>
                      Mark As Taken
                </Link>
            </td>
        </tr>
    )
}

export default bookTerm;