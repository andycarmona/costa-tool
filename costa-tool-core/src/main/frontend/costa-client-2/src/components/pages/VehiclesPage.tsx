import * as React from 'react';
import {BasicMenu} from "../libs/BasicMenu";
import {Container} from "@material-ui/core";
import Typography from "@material-ui/core/Typography";
import {VehicleTable} from "../libs/VehicleTable";
import axios from "axios";

export interface AssetInfoProps {
}

export interface AssetInfoState {
}

interface Vehicle {
    id: string;
    name: string;
}

const baseURL = "localhost:1337/vehicle/list";

export class VehiclesPage extends React.Component<AssetInfoProps,
    AssetInfoState> {
    constructor(props: AssetInfoProps) {
        super(props);
    }

    componentDidMount(): void {
        axios.get<Vehicle>(baseURL)
            .then(response => {
                console.log(response.data);
            }).catch(e => {
            console.log(e);
        });
    }

    public render() {
        return (
            <div>
                <BasicMenu/>
                <Container>
                    <Typography component="div" style={{backgroundColor: '#cfe8fc', height: '100vh'}}>
                        <VehicleTable/>
                    </Typography>
                </Container>
            </div>)
    }
}