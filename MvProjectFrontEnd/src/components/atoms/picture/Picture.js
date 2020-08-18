import styled from "styled-components";
import React from 'react';


const picture = (props) => {

    return (
        <img {...props} src='https://images.unsplash.com/photo-1573376670774-4427757f7963?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1351&q=80' alt="foto-candidato">{props.children}</img>
    );

}
export const Picture = styled(picture)`
    width:8vw;
    height:14vh;
    border-radius: 50%;
`