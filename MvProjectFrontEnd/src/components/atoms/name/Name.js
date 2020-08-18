import styled from "styled-components";
import React from 'react';

const name = (props) => {

    return (
        <h1 {...props}>{props.children}</h1>
    );

}
export const Name = styled(name)`
    color: #100A24;
    font-family: 'Roboto', sans-serif;
    margin:20px;
`