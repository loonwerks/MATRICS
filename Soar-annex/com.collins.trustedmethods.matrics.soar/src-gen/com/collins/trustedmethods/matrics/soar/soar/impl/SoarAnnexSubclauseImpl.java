/**
 * Copyright (c) 2023, Collins Aerospace.
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
 * Generated by Xtext version 2.25.0.
 */
package com.collins.trustedmethods.matrics.soar.soar.impl;

import com.collins.trustedmethods.matrics.soar.soar.SoarAnnexSubclause;
import com.collins.trustedmethods.matrics.soar.soar.SoarPackage;
import com.collins.trustedmethods.matrics.soar.soar.SoarProduction;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.osate.aadl2.impl.AnnexSubclauseImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Annex Subclause</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.collins.trustedmethods.matrics.soar.soar.impl.SoarAnnexSubclauseImpl#getSoarAnnexProductions <em>Soar Annex Productions</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SoarAnnexSubclauseImpl extends AnnexSubclauseImpl implements SoarAnnexSubclause
{
  /**
   * The cached value of the '{@link #getSoarAnnexProductions() <em>Soar Annex Productions</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSoarAnnexProductions()
   * @generated
   * @ordered
   */
  protected EList<SoarProduction> soarAnnexProductions;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SoarAnnexSubclauseImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return SoarPackage.Literals.SOAR_ANNEX_SUBCLAUSE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<SoarProduction> getSoarAnnexProductions()
  {
    if (soarAnnexProductions == null)
    {
      soarAnnexProductions = new EObjectContainmentEList<SoarProduction>(SoarProduction.class, this, SoarPackage.SOAR_ANNEX_SUBCLAUSE__SOAR_ANNEX_PRODUCTIONS);
    }
    return soarAnnexProductions;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case SoarPackage.SOAR_ANNEX_SUBCLAUSE__SOAR_ANNEX_PRODUCTIONS:
        return ((InternalEList<?>)getSoarAnnexProductions()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case SoarPackage.SOAR_ANNEX_SUBCLAUSE__SOAR_ANNEX_PRODUCTIONS:
        return getSoarAnnexProductions();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case SoarPackage.SOAR_ANNEX_SUBCLAUSE__SOAR_ANNEX_PRODUCTIONS:
        getSoarAnnexProductions().clear();
        getSoarAnnexProductions().addAll((Collection<? extends SoarProduction>)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case SoarPackage.SOAR_ANNEX_SUBCLAUSE__SOAR_ANNEX_PRODUCTIONS:
        getSoarAnnexProductions().clear();
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case SoarPackage.SOAR_ANNEX_SUBCLAUSE__SOAR_ANNEX_PRODUCTIONS:
        return soarAnnexProductions != null && !soarAnnexProductions.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //SoarAnnexSubclauseImpl
