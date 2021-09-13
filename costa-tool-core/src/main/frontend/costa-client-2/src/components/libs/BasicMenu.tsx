import React from "react";
import Button from "@material-ui/core/Button";
import {Menu} from "@material-ui/core";
import MenuItem from "@material-ui/core/MenuItem";
import {NavLink} from "react-router-dom";

export function BasicMenu() {
    const [anchorEl, setAnchorEl] = React.useState<null | HTMLElement>(null);

    const handleClick = (event: React.MouseEvent<HTMLButtonElement>) => {
        setAnchorEl(event.currentTarget);
    };

    const handleClose = () => {
        setAnchorEl(null);
    };

    return (
        <div>
            <Button aria-controls="simple-menu" aria-haspopup="true" onClick={handleClick}>
                Open Menu
            </Button>
            <Menu
                id="simple-menu"
                anchorEl={anchorEl}
                keepMounted
                open={Boolean(anchorEl)}
                onClose={handleClose}
            >
                <MenuItem onClick={handleClose}>
                    <NavLink to="/"> Start </NavLink>
                </MenuItem>
                <MenuItem onClick={handleClose}>
                    <NavLink to="/vehicles"> Vehicles list </NavLink>
                </MenuItem>
            </Menu>
        </div>
    );
}