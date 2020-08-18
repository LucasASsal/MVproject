import React from 'react';
import styled from "styled-components";
import { Name } from '../../atoms/name/Name';
import { Picture } from '../../atoms/picture/Picture';
import { Container } from '../../atoms/container/Container'
import { StyledButton } from '../../atoms/button/StyledButton';
import { deleteProduct } from '../../../middleware/serviceHandler';

const card = (props) => {

    function deleteProductReloader(codigo) {
        deleteProduct(codigo);
        window.location.reload(false);
    }
    return (
        <div>
            <Container row='row' center='center'{...props}>

                <Name>{props.name}</Name>
                CLIQUE PARA EDITAR
                <StyledButton color="#FCBD16" onClick={() => deleteProductReloader(props.codigo)}>Deletar</StyledButton>



            </Container>


        </div>
    );
}

export const Card1 = styled(card)`
    background-color: #F2FFFA;
    margin-bottom: 10px;
    margin-top: 10px;
    height: 100%;
    width: 100%;
    padding:20px;
    border-radius:8px;
    display: flex;
    justify-content: space-between;
    align-items: center;
    z-index:4;
    /* box-shadow: 5px 10px black;
    transition: width 0.3s, height 0.3s, box-shadow 0.3s; */
    /* :hover {
        background-color: #F8F8F8;
        height: 170px;
        width: 840px;
        box-shadow: 12px 14px  4px 3px #383838;
      } */
    
`