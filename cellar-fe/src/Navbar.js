import { Link, useMatch, useResolvedPath } from "react-router-dom"
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faWineGlass } from '@fortawesome/free-solid-svg-icons';

export default function Navbar() {
    const path = window.location.pathname
    return ( 
        <nav className="nav">
            <div className="site-title-container">
                <Link to="/" className="site-title">
                    The Cellar
                </Link>
                <img src="/stairway.png" alt="Icon" />
        </div>
        <ul>
          <CustomLink to="/wine">Wine</CustomLink>
          <CustomLink to="/beer">Beer</CustomLink>
        </ul>
      </nav>
      
    )
}

function CustomLink({ to, children, ...props}) {
    const resolvedPath = useResolvedPath(to)
    const isActive = useMatch({ path: resolvedPath.pathname, end: true })
    return (
        <li className={isActive ? "active" : ""}>
            <Link to={to} {...props}>
                {children}
            </Link>
        </li>
    )
}