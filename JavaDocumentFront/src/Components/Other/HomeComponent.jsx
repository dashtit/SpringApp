import React, { Component } from "react";

class HomeComponent extends Component {
  constructor(props) {
    super(props);
    this.state = {};
  }

  render() {
    return (
      <div style={{ paddingTop: "100px" }} className=" text-center">
        <h2>Application List</h2>
      </div>
    );
  }
}

export default HomeComponent;
