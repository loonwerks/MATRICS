/**
 * Copyright (c) 2024, Collins Aerospace.
 * Developed with the sponsorship of Defense Advanced Research Projects Agency (DARPA).
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this data, 
 * including any software or models in source or binary form, as well as any drawings, specifications, 
 * and documentation (collectively "the Data"), to deal in the Data without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, 
 * and/or sell copies of the Data, and to permit persons to whom the Data is furnished to do so, 
 * subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all copies or 
 * substantial portions of the Data.
 * 
 * THE DATA IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT 
 * LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. 
 * IN NO EVENT SHALL THE AUTHORS, SPONSORS, DEVELOPERS, CONTRIBUTORS, OR COPYRIGHT HOLDERS BE LIABLE 
 * FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, 
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE DATA OR THE USE OR OTHER DEALINGS IN THE DATA.
 * 
 * Generated by Xtext version 2.33.0.
 */
package com.collins.trustedmethods.matrics.soar.soar;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Production</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.collins.trustedmethods.matrics.soar.soar.SoarProduction#getName <em>Name</em>}</li>
 *   <li>{@link com.collins.trustedmethods.matrics.soar.soar.SoarProduction#getDoc <em>Doc</em>}</li>
 *   <li>{@link com.collins.trustedmethods.matrics.soar.soar.SoarProduction#getFlag <em>Flag</em>}</li>
 *   <li>{@link com.collins.trustedmethods.matrics.soar.soar.SoarProduction#getConditions <em>Conditions</em>}</li>
 *   <li>{@link com.collins.trustedmethods.matrics.soar.soar.SoarProduction#getActions <em>Actions</em>}</li>
 * </ul>
 *
 * @see com.collins.trustedmethods.matrics.soar.soar.SoarPackage#getSoarProduction()
 * @model
 * @generated
 */
public interface SoarProduction extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see com.collins.trustedmethods.matrics.soar.soar.SoarPackage#getSoarProduction_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link com.collins.trustedmethods.matrics.soar.soar.SoarProduction#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Doc</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Doc</em>' attribute.
   * @see #setDoc(String)
   * @see com.collins.trustedmethods.matrics.soar.soar.SoarPackage#getSoarProduction_Doc()
   * @model
   * @generated
   */
  String getDoc();

  /**
   * Sets the value of the '{@link com.collins.trustedmethods.matrics.soar.soar.SoarProduction#getDoc <em>Doc</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Doc</em>' attribute.
   * @see #getDoc()
   * @generated
   */
  void setDoc(String value);

  /**
   * Returns the value of the '<em><b>Flag</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Flag</em>' attribute.
   * @see #setFlag(String)
   * @see com.collins.trustedmethods.matrics.soar.soar.SoarPackage#getSoarProduction_Flag()
   * @model
   * @generated
   */
  String getFlag();

  /**
   * Sets the value of the '{@link com.collins.trustedmethods.matrics.soar.soar.SoarProduction#getFlag <em>Flag</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Flag</em>' attribute.
   * @see #getFlag()
   * @generated
   */
  void setFlag(String value);

  /**
   * Returns the value of the '<em><b>Conditions</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Conditions</em>' containment reference.
   * @see #setConditions(ConditionSide)
   * @see com.collins.trustedmethods.matrics.soar.soar.SoarPackage#getSoarProduction_Conditions()
   * @model containment="true"
   * @generated
   */
  ConditionSide getConditions();

  /**
   * Sets the value of the '{@link com.collins.trustedmethods.matrics.soar.soar.SoarProduction#getConditions <em>Conditions</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Conditions</em>' containment reference.
   * @see #getConditions()
   * @generated
   */
  void setConditions(ConditionSide value);

  /**
   * Returns the value of the '<em><b>Actions</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Actions</em>' containment reference.
   * @see #setActions(ActionSide)
   * @see com.collins.trustedmethods.matrics.soar.soar.SoarPackage#getSoarProduction_Actions()
   * @model containment="true"
   * @generated
   */
  ActionSide getActions();

  /**
   * Sets the value of the '{@link com.collins.trustedmethods.matrics.soar.soar.SoarProduction#getActions <em>Actions</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Actions</em>' containment reference.
   * @see #getActions()
   * @generated
   */
  void setActions(ActionSide value);

} // SoarProduction
