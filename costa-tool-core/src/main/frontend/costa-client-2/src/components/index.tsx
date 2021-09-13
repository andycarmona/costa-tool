import React from 'react'
import ReactDOM from 'react-dom'
import {Route, BrowserRouter as Router, Switch, NavLink} from 'react-router-dom'
import {VehiclesPage} from "./pages/VehiclesPage";
import {BasicMenu} from "./libs/BasicMenu";
import {Container} from "@material-ui/core";
import Typography from "@material-ui/core/Typography";

const App = () => (
    <div>
        <BasicMenu/>
        <Container>
            <Typography component="div" style={{ backgroundColor: '#cfe8fc', height: '100vh' }}>
               VGCS Costa viewer
            </Typography>
        </Container>
    </div>
);

const routing = (
    <Router>
        <div className="page">
            <Switch>
                <Route exact path="/" component={App}/>
                <Route exact path="/vehicles" component={VehiclesPage}/>
                <Route path="*" component={App} />
            </Switch>
        </div>
    </Router>
)

ReactDOM.render(
    routing,
    document.getElementById("output")
);