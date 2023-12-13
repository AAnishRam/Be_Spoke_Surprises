import React, { useState } from 'react';
import { MDBBtn, MDBContainer, MDBRow, MDBCol, MDBInput } from 'mdb-react-ui-kit';
import './Login.css';
import Register from './Register';
import { useNavigate } from 'react-router-dom';
import { toast, ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

const Login = () => {
  const navi = useNavigate();
  const [showLogin, setShowLogin] = useState(true);
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');

  const isValidEmail = (email) => {
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return emailRegex.test(email);
  };

  const toggleLogin = () => {
    setShowLogin(!showLogin);
  };

  const handleLogin = () => {
    if (!email || !password) {
      toast.error('Please fill in both email and password fields.');
      return;
    }

    if (!isValidEmail(email)) {
      toast.error('Please enter a valid email address.');
      return;
    }

    // Perform your login logic here
    toast.success('Login successful!');
    navi("/");

    console.log('Login successful!');
  };

  return (
    <MDBContainer className="my-5 gradient-form">
      <MDBRow>
        <MDBCol md="6" className="mb-5">
          {showLogin ? (
            <div className="d-flex flex-column ms-md-5">
              <div className="text-center">
                <img
                  src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/lotus.webp"
                  style={{ width: '185px' }}
                  alt="logo"
                />
                <h4 style={{ color: '#fff' }} className="mt-1 mb-5 pb-1">
                  We are Be Spoke Surprises Team
                </h4>
              </div>

              <p>Please login to your account</p>

              <MDBInput
                className='label'
                wrapperClass='mb-4'
                label='Email address'
                id='form1'
                type='email'
                value={email}
                onChange={(e) => setEmail(e.target.value)}
                style={{ color: 'white' }}
              />
              <MDBInput
                className='label'
                wrapperClass='mb-4'
                label='Password'
                id='form2'
                type='password'
                value={password}
                style={{ color: 'white' }}
                onChange={(e) => setPassword(e.target.value)}
              />

              <div className="text-center pt-1 mb-5 pb-1">
                <MDBBtn onClick={handleLogin} className="mb-4 w-100 gradient-custom-2">
                  Sign in
                </MDBBtn>
                <a className="text-muted" href="#!">
                  Forgot password?
                </a>
              </div>

              <div className="d-flex flex-row align-items-center justify-content-center pb-4 mb-4">
                <p className="mb-0">Don't have an account?</p>
                <MDBBtn outline className='mx-2' color='danger' onClick={toggleLogin}>
                  REGISTER
                </MDBBtn>
              </div>
            </div>
          ) : (
            <Register toggleLogin={toggleLogin} />
          )}
        </MDBCol>

        <MDBCol md="6" className="mb-5">
          <div className="d-flex flex-column justify-content-center gradient-custom-2 h-100 mb-4">
            <div className="text-white px-3 py-4 p-md-5 mx-md-4">
              <h4 className="mb-4">Embark on a journey with BeSpokeSurprises</h4>
              <p className="small mb-0">
                Embark on a journey with BeSpokeSurprises, where magic resides in every login. We,
                The Artisans of Elation, weave enchantment into every curated gift. Within the
                tapestry of your moments, discover personalized wonders, a symphony of bespoke
                surprises. Unveil the extraordinary as you log in — for in every stroke of our craft,
                your story becomes poetry, and every gift, a stanza in the melody of your life.
              </p>
            </div>
          </div>
        </MDBCol>
      </MDBRow>

      {/* Add the ToastContainer at the end of the component */}
      <ToastContainer />
    </MDBContainer>
  );
};

export default Login;
