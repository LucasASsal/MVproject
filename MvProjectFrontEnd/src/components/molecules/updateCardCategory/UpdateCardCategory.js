import React, { useState } from 'react';
import styled from "styled-components";
import { StyledButton } from '../../atoms/button/StyledButton';
import { updateProductPriceByCategory } from '../../../middleware/serviceHandler';

export default function UpdateCardCategory(props) {

    const [categoria, setcategoria] = useState(1);
    const [preco, setPreco] = useState();


    function updatecategoriaValue(e) {
        setcategoria(e.target.value);
    }

    function updatePrecoValue(e) {
        setPreco(e.target.value);

    }

    function updateProductPriceByCategoryReloader(categoria, preco) {
        updateProductPriceByCategory(categoria, preco);
        window.location.reload(false);
    }
    const categorias = props.categorias;
    return (

        <NewCard>

            <Column>
                <h3>Atualizar produtos por categoria</h3>
                valor percentual de aumento de preco(%):<input style={{ margin: 0 }} type='text' placeholder='valor percentual' value={preco} onChange={e => updatePrecoValue(e)}></input>
                Categoria:
                <select name="select" onChange={(e) => updatecategoriaValue(e)}>

                    {categorias.map((categoria) => <option value={categoria.cdCategoria}>{categoria.dsCategoria}</option>)}

                </select>
            </Column>
            <StyledButton onClick={() => updateProductPriceByCategoryReloader(categoria, preco)}>Atualizar</StyledButton>


        </NewCard>
    )
}

export const NewCard = styled.div`
    width: 65%;
    height: 100%;
    background-color: white;
    border-radius: 8px;
    display: flex;
    padding: 30px;
    justify-content: space-between;
    align-items: center;
    
`

export const Column = styled.div`
    display: flex;
    flex-direction: column;
    width: 80%;
    input {
        margin: 20px;
    }
`