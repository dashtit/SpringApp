import React, { Component } from "react";
import DocumentService from "../../services/DocumentService";
import AuthService from "../../services/AuthService";
import Search from "./SearchComponent";
class ListDocumentsComponent extends Component {
  constructor(props) {
    super(props);
    this.state = {
      documents: [],
      user: {},
      isAdmin: false,
    };
    this.addDocument = this.addDocument.bind(this);
    this.editDocument = this.editDocument.bind(this);
    this.viewDocument = this.viewDocument.bind(this);
    this.deleteDocument = this.deleteDocument.bind(this);
  }
  componentDidMount() {
    DocumentService.getDocuments().then((res) => {
      this.setState({ documents: res.data });
    });
    const user = AuthService.getCurrentUser();
    if (user) {
      this.setState({
        user: user,
        isAdmin: user.roles.includes("ROLE_ADMIN"),
      });
    }
  }

  deleteDocument(id) {
    DocumentService.deleteDocument(id).then((res) => {
      this.setState({
        documents: this.state.documents.filter(
          (mydocument) => mydocument.id !== id
        ),
      });
    });
  }

  viewDocument(id) {
    this.props.history.push(`/view-document/${id}`);
  }
  editDocument(id) {
    this.props.history.push(`/add-document/${id}`);
  }

  addDocument() {
    this.props.history.push("/add-document/_add");
  }

  render() {
    return (
      <div>
        <h2 className="text-center">App List</h2>
        {this.state.isAdmin && (
          <div className="row">
            <button className="btn btn-dark" onClick={this.addDocument}>
              {" "}
              Add App
            </button>
          </div>
        )}
        <br></br>
        <Search />
        <div className="row">
          <table className="table table-striped table-bordered">
            <thead>
              <tr>
                <th> Title</th>
                <th> Description</th>
                <th> Actions</th>
              </tr>
            </thead>
            <tbody>
              {this.state.documents.map((document) => (
                <tr key={document.id}>
                  <td> {document.title} </td>
                  <td> {document.description}</td>
                  <td>
                    {this.state.isAdmin && (
                      <button
                        onClick={() => this.editDocument(document.id)}
                        className="btn btn-dark mb-1"
                      >
                        Update{" "}
                      </button>
                    )}
                    {this.state.isAdmin && (
                      <button
                        onClick={() => this.deleteDocument(document.id)}
                        className="btn btn-danger ml-1 mb-1"
                      >
                        Delete{" "}
                      </button>
                    )}

                    <button
                      onClick={() => this.viewDocument(document.id)}
                      className="btn btn-dark ml-1 mb-1"
                    >
                      View{" "}
                    </button>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      </div>
    );
  }
}

export default ListDocumentsComponent;
